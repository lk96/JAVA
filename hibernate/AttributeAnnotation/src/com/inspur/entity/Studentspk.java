package com.inspur.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

//ѧ��������
@Embeddable
public class Studentspk implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;//���֤����
	private String sid;//ѧ��
	public Studentspk() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	public Studentspk(String id, String sid) {
		super();
		this.id = id;
		this.sid = sid;
	}
	
	
}
