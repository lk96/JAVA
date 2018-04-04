package com.inspur.entity;

import javax.persistence.Embeddable;


/*
 * 地址类
 */
@Embeddable/*表示是一个嵌入类，这个类在的对象在另一个实体类中充当属性*/
public class Address {
	private String postcode;
	private String phone;
	private String address;
	public Address(String postcode, String phone, String address) {
		this.postcode = postcode;
		this.phone = phone;
		this.address = address;
	}
	public Address() {
		super();
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
