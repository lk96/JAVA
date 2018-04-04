package com.inspur.beanscope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = 
		    	 new ClassPathXmlApplicationContext(new String[] {"beanscope.xml"});

//		    	CustomerService custA = (CustomerService)context.getBean("customerService");
//		    	custA.setMessage("Message by custA");
//		    	System.out.println("Message : " + custA.getMessage());
//		    	
//		    	//retrieve it again
//		    	CustomerService custB = (CustomerService)context.getBean("customerService");
//		    	System.out.println("Message : " + custB.getMessage());
		    	
		    	CustomerService2 cust2A = (CustomerService2)context.getBean("customerService2");
		    	cust2A.setMessage("Message by custA");
		    	System.out.println("Message : " + cust2A.getMessage());
		    	
		    	//retrieve it again
		    	CustomerService2 cust2B = (CustomerService2)context.getBean("customerService2");
		    	System.out.println("Message : " + cust2B.getMessage());
	}
}
