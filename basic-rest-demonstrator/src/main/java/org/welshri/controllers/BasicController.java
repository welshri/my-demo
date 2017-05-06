package org.welshri.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@RequestMapping("/basic")
public class BasicController {

	/**
	 * Most basic - no params or uri to inspect
	 * http://localhost:8080/
	 */
    @RequestMapping("/")
    @ResponseBody
    String helloWorld() {
        return "Hello World!";
    }
    
    /**
     * Deals with a param
     * http://localhost:8080/basic/personal?firstName=jim
     */
    @RequestMapping("/personal")
    @ResponseBody
    String hello(@RequestParam("firstName")String firstName) {
        return "Hello " + firstName + "!";
    }

    /**
     * Deals with a uri
     * http://localhost:8080/basic/pet/rufus
     */
    @RequestMapping("/pet/{id}")
    @ResponseBody
    String helloEmployee(@PathVariable String id) {
        return "Hello valued pet " + id + "!";
    }
    

}