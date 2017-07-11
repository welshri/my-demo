package org.welshri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.welshri.dao.employee.EmployeeDAO;

@EnableAutoConfiguration
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public void addEmployee(Employee e) {
		org.welshri.dao.employee.Employee d = EmployeeUtils.serviceToDAO(e);
		employeeDAO.addEmployee(d);
	}

	@Override
	public Employee getEmployee(Integer employeeNumber) {
		org.welshri.dao.employee.Employee d = employeeDAO.getEmployee(employeeNumber);
		Employee e = null;
		if (d != null) {
			e = EmployeeUtils.DAOToService(d);
		}
		return e;
	}
	
	@Override
	public Long getAllEmployeesFilteredFirstNameCount(String firstName) {
		 return employeeDAO.getEmployees()
			.stream()
			.parallel()
			.filter(e -> e.getFirstName().equalsIgnoreCase(firstName))
			.count();
	}
}