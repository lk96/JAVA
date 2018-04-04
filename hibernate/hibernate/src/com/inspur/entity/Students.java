package com.inspur.entity;

import java.sql.Blob;
import java.util.Date;

public class Students {
	 private int sid;
	 private String sname;
	 private String gender;
	 private Date birthday;
//	 private String address;
	 private Blob picture;
	 private Address address;
	public Students(int sid, String sname, String gender, Date birthday,
			Address address) {
//		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}
	public Students() {
//		super();
	}
	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", gender="
				+ gender + ", birthday=" + birthday + ", address=" + address
				+ "]";
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
	public Blob getPicture() {
		return picture;
	}
	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
