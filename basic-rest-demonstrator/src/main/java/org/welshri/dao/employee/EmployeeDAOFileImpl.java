package org.welshri.dao.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.welshri.dao.AsyncFileHelper;
import org.welshri.dao.employee.Employee;

/**
 * I think on the next refactor, I will turn this into JSON
 * 
 * @author richard
 *
 */
@Repository
@EnableAutoConfiguration
public class EmployeeDAOFileImpl implements EmployeeDAO {

	@Autowired
	AsyncFileHelper asyncFileHelper;

	private static final String SUBJECT = "employee";

	@Override
	public void addEmployee(Employee employee) {
		StringBuffer transformed = new StringBuffer();
		String key = null;
		if (this.validate(employee)) {
			key = this.transformToBuffer(employee, transformed);
		}
		if (key != null) {
			asyncFileHelper.writeData(AsyncFileHelper.REPO_ROOT + "/" + SUBJECT + "/" + key + ".txt",
					transformed.toString().getBytes());
		}
	}

	/**
	 * SKELETON ONLY - check for new line chars for example.
	 * 
	 * @param employee
	 * @return
	 */
	public boolean validate(Employee employee) {
		boolean problematicData = false;
		//TODO error on new line char.

		if (problematicData) {
			throw new RuntimeException("Employee object failed validation");
		}
		return true;
	}

	/**
	 * Its a bit more obvious to just use employee.toString() but its good practice
	 * to have  lightly coupled DAO, Service, Controller layers
	 * a
	 * @param employee
	 * @return
	 */
	public String transformToBuffer(Employee employee, StringBuffer transformed) {
		String firstName = employee.getFirstName();
		String lastName = employee.getLastName();
		String employeeNumber = String.valueOf(employee.getEmployeeNumber());
		String jobDescription = employee.getJobDescription();
		transformed.append(firstName).append("\n");
		transformed.append(lastName).append("\n");
		transformed.append(employeeNumber).append("\n");
		transformed.append(jobDescription).append("\n");
		return employeeNumber;
	}

	public Employee getEmployee(Integer employeeNumber) {
		Employee e = null;
		List<String> fileData = asyncFileHelper.getData(AsyncFileHelper.REPO_ROOT + "/" + SUBJECT + "/" + String.valueOf(employeeNumber) + ".txt");
		if (!CollectionUtils.isEmpty(fileData)) {
			e = new Employee(fileData.get(0), fileData.get(1), Integer.valueOf(fileData.get(2)), fileData.get(3));
		}
		return e;
		
	}
}
