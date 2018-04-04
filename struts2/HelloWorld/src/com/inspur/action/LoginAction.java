package com.inspur.action;

import po.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>  {

	//第三种，使用ModelDriven接收参数 实现ModelDriven接口
	private User user=new User();
	@Override
	public User getModel() {
		return user;
	}
	public String login(){
		//input第一种方法
		/*if(user.getUsername()==null||"".equals(user.getUsername())){
			this.addFieldError("user", "用户名不能为空");
			return INPUT;
		}*/
		System.out.println(user.getUsername());
		System.out.println(user.getBookList().get(0));
		System.out.println(user.getBookList().get(1));
		System.out.println(user.getUserList().get(1).getUsername());
		return SUCCESS;
	}
	//input第二种方法
	/*@Override
	public void validate() {
		if(user.getUsername()==null||"".equals(user.getUsername())){
			this.addFieldError("user", "用户名不能为空");
	}
	}*/
	
	//第二种使用DomainModel接收参数
	/*private User user;
	public String login(){
		System.out.println(user.getUsername());
		return SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}*/
	
//	第一种方法传参数,使用Action的属性接收参数
	/*private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String login(){
		System.out.println(username);
		return SUCCESS;
	}*/
}
