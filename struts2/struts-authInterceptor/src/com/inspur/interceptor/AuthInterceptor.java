package com.inspur.interceptor;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context=ActionContext.getContext();
		Map<String, Object> session=context.getSession();
	
		if(session.get("loginInfo")!=null){
			String result=invocation.invoke();
			return result;
		}
		else {
			return "login";
		}
		
	}

}
