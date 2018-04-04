package onetoone_bfk;

import java.util.Date;

import javax.persistence.Temporal;

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
		//������һ�����֤����
		IdCard card=new IdCard("123456789012345678", "����");
		Students stu=new Students(card, "��", new Date(), "c");
		session.save(card);
		session.save(stu);
		tx.commit();
		session.close();
	}
}
