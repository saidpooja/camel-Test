package com.demo.example4;

public class EmployeeToSql {

	public String toSql() {

		Employee emp = new Employee(3, "Swapnil","Ghatkopar", "Mumbai", "Leader", "Mumbai", "Banking");
		StringBuilder sb = new StringBuilder();
		sb.append("insert into employee (empId, name, address1,address2,designation,city,department) values (");
		sb.append("'").append(emp.getId()).append("', ");
		sb.append("'").append(emp.getName()).append("', ");
		sb.append("'").append(emp.getAddress1()).append("', ");
		sb.append("'").append(emp.getAddress2()).append("') ");
		sb.append("'").append(emp.getDesignation()).append("', ");
		sb.append("'").append(emp.getCity()).append("', ");
		sb.append("'").append(emp.getDepartment()).append("', ");

		System.out.println(sb.toString());

		return sb.toString();
	}

}
