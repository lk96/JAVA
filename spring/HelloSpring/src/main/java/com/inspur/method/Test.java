package com.inspur.method;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main( String[] args )
    {
    	ConfigurableApplicationContext context = 
		new ClassPathXmlApplicationContext(new String[] {"method.xml"});
	
    	CustomerService cust = (CustomerService)context.getBean("customerService");
    	
    	System.out.println(cust);
    	
    	context.close();
    }
}
