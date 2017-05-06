package org.welshri.service;

public class Employee extends Person {
	
	private Integer employeeNumber;
	private String jobDescription;
	
	public Employee(String firstName, String lastName, Integer employeeNumber, String jobDescription) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeNumber = employeeNumber;
		this.jobDescription = jobDescription;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Integer getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

}
