package com.inspur.hellospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.inspur.tutorial.spring.helloworld.HelloWorld;
import com.inspur.tutorial.spring.helloworld.HelloWorldService;

public class HelloProgram {
	 public static void main(String[] args) {
         
	        ApplicationContext context =
	                new ClassPathXmlApplicationContext("beans.xml");
	         
	        HelloWorldService service =
	             (HelloWorldService) context.getBean("helloWorldService");
	          
	        HelloWorld hw= service.getHelloWorld();
	         
	        hw.sayHello();
	    }
}
