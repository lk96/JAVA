package com.inspur.entity;

import java.util.Date;

import javax.persistence.Entity;/*JPA注解*/
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 学生实体类
 */

@Entity
@Table(name="t_students",schema="scott")
public class Students {
	
	private int sid;
	private String sname;
	private String gender;
	private Date birthday;
	private String major;
//	private String address;
	private Address add;
	public Students() {
	}

	public Students(int sid, String sname, String gender, Date birthday,
			String major,Address add) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
//		this.address = address;
		this.add=add;
	}
	@Id
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

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}
	
	

}
