package com.inspur.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.inspur.entity.Employee;
import com.inspur.util.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		Session session=HibernateUtil.getSession();
//		Employee emp=(Employee) session.get(Employee.class, 1);
//		System.out.println(emp.getName());
//		//ʹ�ò��õ�session���еڶ��β�ѯ
//		//session=HibernateUtil.getSession();
//		
//		//evict�������һ�������е�ָ������
//	
//		//session.evict(emp);
//		//clear���һ����������������
//		session.clear();
//		emp=(Employee) session.get(Employee.class, 1);
//		System.out.println(emp.getName());
		
		Query query=session.createQuery("from Employee");
		List<Employee> list=query.list();
		for (Employee employee : list) {
			System.out.println(employee.getName());
		}
//		list=query.list();
//		for (Employee employee : list) {
//			System.out.println(employee.getName());
//		}
		Iterator it=query.iterate();
		while (it.hasNext()) {
			Employee employee = (Employee) it.next();
			System.out.println(employee.getName());
		}
		HibernateUtil.closeSession(session);
	}
}
