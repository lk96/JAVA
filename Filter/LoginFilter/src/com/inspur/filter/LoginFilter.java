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
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	private FilterConfig config;

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
		String noLoginPaths = config.getInitParameter("noLoginPaths");
		String charset=config.getInitParameter("charset");
		if(charset==null){
			charset="UTF-8";
		}
		request.setCharacterEncoding(charset);
		
		if (noLoginPaths != null) {
			String[] strArry = noLoginPaths.split(";");
			for (int i = 0; i < strArry.length; i++) {
				if (strArry[i] == null || "".equals(strArry[i]))
					continue;
				if (request.getRequestURI().indexOf(strArry[i]) != -1) {
					arg2.doFilter(arg0, arg1);
					return;
				}
			}

		}

		if (session.getAttribute("username") != null) {
			arg2.doFilter(arg0, arg1);
		} else {
			response.sendRedirect("login.jsp");
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		config = arg0;
	}

}
