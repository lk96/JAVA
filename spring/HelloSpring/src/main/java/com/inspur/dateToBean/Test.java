package com.inspur.dateToBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"date.xml");

		Customer cust = (Customer) context.getBean("customer");
		System.out.println(cust);
		
	}
}
