package com.inspur.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {
//method��ʽ��̬Action
	/*	public String add(){
			return SUCCESS;
		}
		public String update(){
			return SUCCESS;
		}*/
//	��̾�ŷ�ʽ��̬Action
	public String add(){
		return "add";
	}
	public String update(){
		return "update";
	}
		
	@Override
	public String execute() throws Exception {
		System.out.println("ִ��Action");
		return SUCCESS;
	}
	
}
