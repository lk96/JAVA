package com.inspur.action;

import po.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>  {

	//�����֣�ʹ��ModelDriven���ղ��� ʵ��ModelDriven�ӿ�
	private User user=new User();
	@Override
	public User getModel() {
		return user;
	}
	public String login(){
		//input��һ�ַ���
		/*if(user.getUsername()==null||"".equals(user.getUsername())){
			this.addFieldError("user", "�û�������Ϊ��");
			return INPUT;
		}*/
		System.out.println(user.getUsername());
		System.out.println(user.getBookList().get(0));
		System.out.println(user.getBookList().get(1));
		System.out.println(user.getUserList().get(1).getUsername());
		return SUCCESS;
	}
	//input�ڶ��ַ���
	/*@Override
	public void validate() {
		if(user.getUsername()==null||"".equals(user.getUsername())){
			this.addFieldError("user", "�û�������Ϊ��");
	}
	}*/
	
	//�ڶ���ʹ��DomainModel���ղ���
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
	
//	��һ�ַ���������,ʹ��Action�����Խ��ղ���
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
