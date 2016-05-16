package person;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class Employee extends Person {
	
	private Integer employeeNumber;
	private String jobDescription;
	
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
	
	public static Employee getSampleEmployee() {
		Employee e = new Employee();
		e.setFirstName("first_" + RandomStringUtils.randomAlphabetic(4));
		e.setLastName("last_" + RandomStringUtils.randomAlphabetic(8));
		e.setJobDescription("desc_" + RandomStringUtils.randomAlphabetic(12));
		e.setEmployeeNumber(new Random().ints(0, 100000).iterator().nextInt());
		return e;
	}
	
	

}
