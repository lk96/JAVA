package com.inspur.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  
		ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
//		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		obj.printHelloWorld("Spring Java Config");
	}

}
