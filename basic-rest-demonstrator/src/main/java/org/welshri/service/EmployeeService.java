package org.welshri.service;

public interface EmployeeService {
	
	public void addEmployee(Employee e);
	
	public Employee getEmployee(Integer employeeNumber);

	public Long getAllEmployeesFilteredFirstNameCount(String firstName);

}
