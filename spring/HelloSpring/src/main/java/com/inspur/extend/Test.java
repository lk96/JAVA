package com.inspur.extend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"extend.xml");

		Customer cust = (Customer) context.getBean("CustomerBean");
		System.out.println(cust);
	}
}
