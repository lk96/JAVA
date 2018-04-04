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
		//创建hibernate配置对象
		Configuration config=new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).build();
		//生成sessionFactory
		SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
		SchemaExport export=new SchemaExport(config);
		export.create(true, true);
	}
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
		//创建班级对象
		ClassRoom c1=new ClassRoom("c001","软件工程");
		ClassRoom c2=new ClassRoom("c002","网络工程");
		Students s1=new Students("001","张三","男", new Date(), "计算机");
		Students s2=new Students("002","李四", "女", new Date(), "计算机");
		Students s3=new Students("003","王五", "男", new Date(), "计算机");
		Students s4=new Students("004","赵六", "女", new Date(), "计算机");
		
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
