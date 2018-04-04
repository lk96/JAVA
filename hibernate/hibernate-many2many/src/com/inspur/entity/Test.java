package com.inspur.entity;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.inspur.util.HibernateUtil;

/*
 * 多对多关联关系的配置
 * 同时建立了project和employee之间的双向多对多关联关系
 * 关联关系的维护有project方来处理,并且在保存project对象时会一并保存employee对象
 */
public class Test {

	public static void main(String[] args) {
		Project project1 = new Project(1005, "项目5");
		Project project2 = new Project(1004, "项目4");
		Employee employee1 = new Employee(5, "j");
		Employee employee2 = new Employee(6, "t");
		// 参加项目一的有张三和李四
		project1.getEmployees().add(employee1);
		project1.getEmployees().add(employee2);
		// 参加项目2的只有张三
		project2.getEmployees().add(employee1);
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(project1);
		session.save(project2);
		tx.commit();
		HibernateUtil.closeSession(session);
	}
}
