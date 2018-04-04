package com.inspur.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter {

	public void destroy() {
		System.out.println("destory-------SecondFilter");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("start---doFilter----SecondFilter");
		arg2.doFilter(arg0, arg1);
		System.out.println("end---doFilter----SecondFilter");
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init-------SecondFilter");
	}

}
