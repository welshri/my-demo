package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class Runner {

	//need to component scan or setup stub.
    public static void main(String[] args) throws Exception {
    	Object[] sources = {SampleController.class, JSONController.class, SampleMVCController.class};
		//ApplicationContext ctx = SpringApplication.run(SampleController.class, args);
    	ApplicationContext ctx = SpringApplication.run(sources, args);
    	
    	String[] beanNames = ctx.getBeanDefinitionNames();
    	System.out.println (beanNames.length + " beans defined");
    }

}
