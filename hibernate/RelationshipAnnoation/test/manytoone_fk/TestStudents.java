package manytoone_fk;

import java.util.Date;

import javax.persistence.Temporal;

import oracle.net.aso.s;

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
		//�����༶����
		ClassRoom c1=new ClassRoom("c001","�������");
		ClassRoom c2=new ClassRoom("c002","���繤��");
		Students s1=new Students("001","����","��", new Date(), "�����");
		Students s2=new Students("002","����", "Ů", new Date(), "�����");
		Students s3=new Students("003","����", "��", new Date(), "�����");
		Students s4=new Students("004","����", "Ů", new Date(), "�����");
		
		s1.setClassRoom(c1);
		s2.setClassRoom(c1);
		
		s3.setClassRoom(c2);
		s4.setClassRoom(c2);
		session.save(c1);
		session.save(c2);
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		
//		session.save(c1);
//		session.save(c2);
//		session.save(s1);
//		session.save(s2);
//		session.save(s3);
//		session.save(s4);
		tx.commit();
		session.close();
	}
}
