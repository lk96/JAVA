package com.inspur.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;/*JPA注解*/
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/*
 * 学生实体类
 */

@Entity
@Table(name="t_students",schema="scott")


public class Students implements Serializable{
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	
   /*字符型主键
	 @GeneratedValue(generator="sid")
	 @GenericGenerator(name="sid",strategy="assigned")
	 @Column(length=8)
	private String sid;*/
	/*
	 * @GenericGenerator(name="sid",strategy="assigned")
	 * @Column(length=8)
	 * */
	@EmbeddedId
	private Studentspk pk;

	private String sname;
	private String gender;
	private Date birthday;
	private String major;
//	private String address;
	@Transient//该属性不映射到数据库中
	private double salary;
	@Embedded
	private Address add;
	public Students() {
	}

	public Students(Studentspk pk, String sname, String gender, Date birthday,
			String major,Address add) {
		super();
		this.pk = pk;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
//		this.address = address;
		this.add=add;
	}
	
	
	public Studentspk getPk() {
		return pk;
	}

	public void setPk(Studentspk pk) {
		this.pk = pk;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	

}
