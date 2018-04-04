package com.inspur.entity;

import org.hibernate.SessionFactory;
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
}
