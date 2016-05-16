package hello;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController {

	/**
	 * Most basic - no params or uri to inspect
	 * @return
	 */
    @RequestMapping("/")
    @ResponseBody
    String name() {
        return "Hello World!";
    }
    
    /**
     * Deals with a param
     * @param firstName
     * @return
     */
    @RequestMapping("/personal")
    @ResponseBody
    String hello(@RequestParam("firstName")String firstName) {
        return "Hello " + firstName + "!";
    }

    /**
     * Deals with a uri
     * @param args
     * @throws Exception
     */
    @RequestMapping("/employee/{employeeId}")
    @ResponseBody
    String helloEmployee(@PathVariable String employeeId) {
    	System.out.println("debug 100");
        return "Hello valued employee " + employeeId + "!";
    }
    

}