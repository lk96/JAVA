package com.inspur.el;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
	    ApplicationContext context = new ClassPathXmlApplicationContext("el.xml");
 
	    Customer obj = (Customer) context.getBean("customerBean");
	    System.out.println(obj);

	}
}
