package com.inspur.entity;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestStudents {

	@Test
	public void testShemaExport(){
		//创建hibernate配置对象
		Configuration config=new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).build();
		//生成sessionFactory
		SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
		SchemaExport export=new SchemaExport(config);
		export.create(true, true);
	}
	
	/*@Test
	public void addStudents(){
		//创建hibernate配置对象
		Configuration config=new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).build();
		//生成sessionFactory
		SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
		//创建会话
		Session session= sessionFactory.openSession();
		//创建事务
		Transaction tx= session.beginTransaction();
		//创建一个学生对象
		Address add=new Address("111111", "13000000000", "北京");
		Students stu=new Students(20180001, "张三", "男", new Date(), "jav", add);
		session.save(stu);
		tx.commit();
		session.close();
	}*/
	
	@Test
	public void addStudents(){
		//创建hibernate配置对象
		Configuration config=new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).build();
		//生成sessionFactory
		SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
		//创建会话
		Session session= sessionFactory.openSession();
//		创建事务
		Transaction tx= session.beginTransaction();
		//创建一个学生对象
		Address add=new Address("111111", "13000000000", "北京");
		Studentspk pk=new Studentspk("123456","20180001");
		Students stu=new Students(pk, "张三", "男", new Date(), "jav", add);
		session.save(stu);
		tx.commit();
		session.close();
	}
}
