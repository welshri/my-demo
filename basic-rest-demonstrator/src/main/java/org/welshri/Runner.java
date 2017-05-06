package org.welshri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages="org.welshri")
public class Runner {

	//need to component scan or setup stub.
    public static void main(String[] args) throws Exception {
    	SpringApplication.run(Runner.class, args);
    }

}
