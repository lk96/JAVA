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
		//先生成一个身份证对象
		IdCard card=new IdCard("123456789012345678", "张三");
		Students stu=new Students(card, "男", new Date(), "c");
		session.save(card);
		session.save(stu);
		tx.commit();
		session.close();
	}
}
