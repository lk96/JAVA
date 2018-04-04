package com.inspur.aopInterceptor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext appContext = 
	    		new ClassPathXmlApplicationContext(new String[] {"aopInterceptor.xml"});
		
	    	CustomerService cust = (CustomerService)appContext.getBean("customerServiceProxy");
	    	
	    	System.out.println("*************************");
	    	cust.printName();
	    	System.out.println("*************************");
	    	cust.printURL();
	    	System.out.println("*************************");
	    	try{
	    		cust.printThrowException();
	    	}catch(Exception e){
	    		
	    	}
	}
}
