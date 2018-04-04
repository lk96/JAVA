package com.inspur.entity;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.inspur.util.HibernateUtil;

/*
 * ��Զ������ϵ������
 * ͬʱ������project��employee֮���˫���Զ������ϵ
 * ������ϵ��ά����project��������,�����ڱ���project����ʱ��һ������employee����
 */
public class Test {

	public static void main(String[] args) {
		Project project1 = new Project(1005, "��Ŀ5");
		Project project2 = new Project(1004, "��Ŀ4");
		Employee employee1 = new Employee(5, "j");
		Employee employee2 = new Employee(6, "t");
		// �μ���Ŀһ��������������
		project1.getEmployees().add(employee1);
		project1.getEmployees().add(employee2);
		// �μ���Ŀ2��ֻ������
		project2.getEmployees().add(employee1);
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(project1);
		session.save(project2);
		tx.commit();
		HibernateUtil.closeSession(session);
	}
}
