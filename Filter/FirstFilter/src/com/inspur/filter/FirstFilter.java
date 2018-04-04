package com.inspur.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstFilter implements Filter{

	public void destroy() {
		System.out.println("destory------FirstFilter");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("start---doFilter------FirstFilter");
		//arg2.doFilter(arg0, arg1);
		HttpServletRequest request=(HttpServletRequest) arg0;
		HttpServletResponse response=(HttpServletResponse) arg1;
		//重定向
		response.sendRedirect(request.getContextPath()+"/main.jsp");
		//转发
		//request.getRequestDispatcher("main.jsp").forward(arg0, arg1);
		request.getRequestDispatcher("main.jsp").include(arg0, arg1);
		System.out.println("end---doFilter------FirstFilter");
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init------FirstFilter");
	}

}
