package com.inspur.insidebean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inspur.inside.Customer;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = 
		    	  new ClassPathXmlApplicationContext(new String[] {"insidebeans.xml"});

		    	Customer cust = (Customer)context.getBean("CustomerBean");
		    	System.out.println(cust);
	}
}
