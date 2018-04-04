package com.inspur.importimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
//		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		CustomerBo customer = (CustomerBo) context.getBean("customer");
		customer.printMsg("Hello 11");

		SchedulerBo scheduler = (SchedulerBo) context.getBean("scheduler");
		scheduler.printMsg("Hello 22");
	}
}
