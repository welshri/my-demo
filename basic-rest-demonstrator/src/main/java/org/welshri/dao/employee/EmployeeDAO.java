package org.welshri.dao.employee;

import java.util.List;

public interface EmployeeDAO {
	
	public void addEmployee(Employee employee);
	
	public Employee getEmployee(Integer employeeNumber);

	public List<org.welshri.dao.employee.Employee> getEmployees();

}
