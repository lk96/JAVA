package com.inspur.aopInterceptor;

public class HijackThrowException {
	public void afterThrowing(IllegalArgumentException e) throws Throwable {
		System.out.println("HijackThrowException : Throw exception hijacked!");
	}
	
}
