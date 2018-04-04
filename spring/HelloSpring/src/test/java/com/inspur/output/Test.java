package com.inspur.output;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("output.xml");
		OutputHelper oph= (OutputHelper) context.getBean("OutputHelper");
		oph.generateOutput();
	}
}
