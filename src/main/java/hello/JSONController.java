package hello;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import person.Employee;

@Controller
@EnableAutoConfiguration
public class JSONController {
	
	/**
	 * http://www.journaldev.com/2552/spring-restful-web-service-example-with-json-jackson-and-client-program
	 */
	@RequestMapping(value="rest/employee", method = RequestMethod.GET) 
	@ResponseBody
	public Employee getEmployee() {
		Employee e = Employee.getSampleEmployee();
		return e;
	}

}
