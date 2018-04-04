package com.inspur.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	 public static void main( String[] args )
	    {
	    	ApplicationContext context = 
	    		new ClassPathXmlApplicationContext(new String[] {"aop.xml"});

	    	CustomerService cust = (CustomerService)context.getBean("customerService");
	    	System.out.println(cust);
	    	
	    }
}
