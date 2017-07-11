package org.welshri.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.welshri.service.Employee;
import org.welshri.service.EmployeeServiceImpl;
import org.welshri.service.EmployeeUtils;

@Controller
@EnableAutoConfiguration
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	EmployeeServiceImpl employeeService;

	/**
	 * http://www.journaldev.com/2552/spring-restful-web-service-example-with-json-jackson-and-client-program
	 * 
	 * Generates and returns an example
	 */
	@RequestMapping(value = "/generateExample")
	@ResponseBody
	public Employee getEmployee() {
		Employee e = EmployeeUtils.getSampleEmployee();
		System.out.println(e);
		employeeService.addEmployee(e);
		return e;
	}
	
	@RequestMapping(value = "/addEmployee")
	@ResponseBody
	public Integer addEmployee(@RequestParam Map<String,String> requestParams) {		
		String firstName = requestParams.get("firstName");
		String lastName = requestParams.get("lastName");
		Integer employeeNumber = Integer.valueOf(requestParams.get("employeeNumber"));
		String jobDescription = requestParams.get("jobDescription");
		
		Employee e = new Employee(firstName, lastName, employeeNumber, jobDescription);
		employeeService.addEmployee(e);		
		return e.getEmployeeNumber();
	}
	
	@RequestMapping(value = "/{employeeNumber}")
	@ResponseBody
	public Employee getEmployee(@PathVariable String employeeNumber) {
		Employee e = employeeService.getEmployee(Integer.valueOf(employeeNumber));
		return e;
	}
	
	@RequestMapping(value = "/count")
	@ResponseBody
	public Long getEmployeeCount(@RequestParam Map<String,String> requestParams) {
		Optional<String> firstName =  Optional.ofNullable(requestParams.get("firstName"));
		
		if (requestParams.size() != 1 || !firstName.isPresent()) {
			throw new RuntimeException("Only firstName parameter is supported at present");
		}

		return employeeService.getAllEmployeesFilteredFirstNameCount(firstName.get());	
		
	}
	
	
	

}
