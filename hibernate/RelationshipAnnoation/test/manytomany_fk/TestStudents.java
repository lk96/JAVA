package manytomany_fk;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
		Teachers t1=new Teachers("t001", "张老师");
		Teachers t2=new Teachers("t002", "李老师");
		Teachers t3=new Teachers("t003", "王老师");
		Teachers t4=new Teachers("t004", "赵老师");
		//创建班级对象
		Students s1=new Students("001","张三","男", new Date(), "计算机");
		Students s2=new Students("002","李四", "女", new Date(), "计算机");
		Students s3=new Students("003","王五", "男", new Date(), "计算机");
		Students s4=new Students("004","赵六", "女", new Date(), "计算机");
		Set<Teachers> set1=new HashSet<Teachers>();
		set1.add(t1);
		set1.add(t2);
		
		Set<Teachers> set2=new HashSet<Teachers>();
		set2.add(t3);
		set2.add(t4);
		
		Set<Teachers> set3=new HashSet<Teachers>();
		set3.add(t3);
		set3.add(t4);
		set1.add(t1);
		
		Set<Teachers> set4=new HashSet<Teachers>();
		set4.add(t3);
		set4.add(t4);
		set1.add(t2);
		
		s1.setTeachers(set1);
		s2.setTeachers(set2);
		s3.setTeachers(set3);
		s4.setTeachers(set4);
		
		session.save(t1);
		session.save(t2);
		session.save(t3);
		session.save(t4);
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		

		tx.commit();
		session.close();
	}
}
