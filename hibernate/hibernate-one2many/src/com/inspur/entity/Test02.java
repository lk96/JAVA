package com.inspur.entity;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.inspur.util.HibernateUtil;

/*
 * ������һ��ѧ��-->�༶��
 * ʵ�����Ѿ�������˫��һ�Զ࣬Ҳ��˫����һ
 * �ȿ��Է������ѧ�����ҵ���Ӧ�İ༶��Ϣ��Ҳ���Է�����ɰ༶���ҵ�����������ѧ����Ϣ
 */
public class Test02 {
	public static void main(String[] args) {
//		save();
		findGradeByStudent();
	}
	//����
	public static void save(){
		Grade g=new Grade("javaһ��","java�������һ��");
		Student stu1=new Student("����", "��");
		Student stu2=new Student("����", "Ů");
	
		//���ù�����ϵ
		g.getStudents().add(stu1);
		g.getStudents().add(stu2);
		stu1.setGrade(g);
		stu2.setGrade(g);
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.save(g);//��������
//		session.save(stu1);
//		session.save(stu2);
		tx.commit();
		HibernateUtil.closeSession(session);
	}
	//��ѯѧ�����ڰ༶��Ϣ
	public static void findGradeByStudent(){
		Session session=HibernateUtil.getSession();
		Student stu=(Student) session.get(Student.class,2);
		System.out.println(stu.getSid()+","+stu.getSname()+","+stu.getSex());
		Grade g=stu.getGrade();
		System.out.println(g.getGid()+","+g.getGname()+","+g.getGdesc());
	}
	
}
