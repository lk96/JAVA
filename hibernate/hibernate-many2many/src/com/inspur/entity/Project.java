package com.inspur.entity;

import java.util.HashSet;
import java.util.Set;
/*
 * ��Ŀ��
 */
public class Project {
	private int proid;
	private String proname;
	// ���һ��Ա���ļ���
	private Set<Employee> employees = new HashSet<Employee>();

	public Project(int proid, String proname) {
		super();
		this.proid = proid;
		this.proname = proname;
	}

	public Project(int proid, String proname, Set<Employee> employees) {
		super();
		this.proid = proid;
		this.proname = proname;
		this.employees = employees;
	}

	public Project() {
		super();
	}

	public int getProid() {
		return proid;
	}

	public void setProid(int proid) {
		this.proid = proid;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
