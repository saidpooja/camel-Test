package com.demo.example4;

public class Employee {
	
	private int id;
	private String name;
	private String address1;
	private String address2;
	private String designation;
	private String city;
	private String department;
	
	
	
	public Employee() {
		super();
	}
	public Employee(int id, String name, String address1, String address2, String designation, String city,
			String department) {
		super();
		this.id = id;
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.designation = designation;
		this.city = city;
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address1=" + address1 + ", address2=" + address2
				+ ", designation=" + designation + ", city=" + city + ", department=" + department + "]";
	}
	
	
	

}
