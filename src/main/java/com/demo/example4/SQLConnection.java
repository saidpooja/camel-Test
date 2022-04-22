package com.demo.example4;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.spi.Registry;
import com.mysql.cj.jdbc.MysqlDataSource;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;

public class SQLConnection {

	public static void main(String[] args) {

		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/ambadnya");
		dataSource.setUser("root");
		dataSource.setPassword("root");

		EmployeeToSql empObject = new EmployeeToSql();

		SimpleRegistry simpleRegistry = new SimpleRegistry();
		simpleRegistry.put("myDataSource", dataSource);
		simpleRegistry.put("empToSQL", empObject);

		CamelContext context = new DefaultCamelContext(simpleRegistry);

		try {
			context.addRoutes(new RouteBuilder() {

				@Override
				public void configure() throws Exception {
					// Select Query
					from("direct:select").to("jdbc:myDataSource").process(new Processor() {

						@Override
						public void process(Exchange exchange) throws Exception {
							System.out.println("*********" + exchange.getIn().getBody());

						}
					});

					// Insert Route
					from("direct:insert").log("From Tag").to("jdbc:myDataSource").log("GREAT SUCCESS");

				}
			});

			context.start();

			ProducerTemplate pt1 = context.createProducerTemplate();
			pt1.sendBody("direct:select", "select * from employee");

			ProducerTemplate pt2 = context.createProducerTemplate();

			pt2.sendBody("direct:insert",
					"INSERT INTO EMPLOYEE (EMPID,NAME,ADDRESS1,ADDRESS2,DESIGNATION,CITY,DEPARTMENT) "
							+ "VALUES (4,'Swapnil Auti','PANVEL','KAMOTHE','NETWORK ENG', 'MUMBAI','IT')");

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

}
