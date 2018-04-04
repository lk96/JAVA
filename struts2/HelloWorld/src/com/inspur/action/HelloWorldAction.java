package com.inspur.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {
//method方式动态Action
	/*	public String add(){
			return SUCCESS;
		}
		public String update(){
			return SUCCESS;
		}*/
//	感叹号方式动态Action
	public String add(){
		return "add";
	}
	public String update(){
		return "update";
	}
		
	@Override
	public String execute() throws Exception {
		System.out.println("执行Action");
		return SUCCESS;
	}
	
}
