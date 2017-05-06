package org.welshri.service;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class EmployeeUtils {
	
	public static org.welshri.dao.employee.Employee serviceToDAO(Employee e) {
		org.welshri.dao.employee.Employee d = new org.welshri.dao.employee.Employee();
		d.setEmployeeNumber(e.getEmployeeNumber());
		d.setFirstName(e.getFirstName().trim());
		d.setLastName(e.getLastName().trim());
		d.setJobDescription(e.getJobDescription());
		return d;
	}
	
	public static org.welshri.service.Employee getSampleEmployee() {
		Employee e = new Employee();
		e.setFirstName("first_" + RandomStringUtils.randomAlphabetic(4));
		e.setLastName("last_" + RandomStringUtils.randomAlphabetic(8));
		e.setJobDescription("desc_" + RandomStringUtils.randomAlphabetic(12));
		e.setEmployeeNumber(new Random().ints(0, 100000).iterator().nextInt());
		return e;
	}

	public static org.welshri.service.Employee  DAOToService(org.welshri.dao.employee.Employee d) {
		org.welshri.service.Employee e = new Employee();
		e.setFirstName(d.getFirstName());
		e.setLastName(d.getLastName());
		e.setEmployeeNumber(d.getEmployeeNumber());
		e.setJobDescription(d.getJobDescription());
		return e;
	}
}
