package com.inspur.main;

import org.hibernate.Session;

import com.inspur.entity.Employee;
import com.inspur.util.HibernateUtil;

public class Main2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session=HibernateUtil.getSession();
		Employee emp=(Employee) session.get(Employee.class, 1);
		System.out.println(emp.getName());
		 session=HibernateUtil.getSession();
		 emp=(Employee) session.get(Employee.class, 1);
			System.out.println(emp.getName());
		HibernateUtil.closeSession(session);
	}

}
