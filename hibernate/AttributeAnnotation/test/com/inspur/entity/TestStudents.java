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
		//����hibernate���ö���
		Configuration config=new Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).build();
		//����sessionFactory
		SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
		SchemaExport export=new SchemaExport(config);
		export.create(true, true);
	}
	
	/*@Test
	public void addStudents(){
		//����hibernate���ö���
		Configuration config=new Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).build();
		//����sessionFactory
		SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
		//�����Ự
		Session session= sessionFactory.openSession();
		//��������
		Transaction tx= session.beginTransaction();
		//����һ��ѧ������
		Address add=new Address("111111", "13000000000", "����");
		Students stu=new Students(20180001, "����", "��", new Date(), "jav", add);
		session.save(stu);
		tx.commit();
		session.close();
	}*/
	
	@Test
	public void addStudents(){
		//����hibernate���ö���
		Configuration config=new Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).build();
		//����sessionFactory
		SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
		//�����Ự
		Session session= sessionFactory.openSession();
//		��������
		Transaction tx= session.beginTransaction();
		//����һ��ѧ������
		Address add=new Address("111111", "13000000000", "����");
		Studentspk pk=new Studentspk("123456","20180001");
		Students stu=new Students(pk, "����", "��", new Date(), "jav", add);
		session.save(stu);
		tx.commit();
		session.close();
	}
}
