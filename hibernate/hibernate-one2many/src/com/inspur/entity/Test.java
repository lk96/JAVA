package com.inspur.entity;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.inspur.util.HibernateUtil;

/*
 * ����һ�Զ��ϵ���༶-->ѧ����
 * ������ϵ�󣬿��Է���Ĵ�һ�����󵼺�����һ������
 */
public class Test {
	public static void main(String[] args) {
		add();
//		findStudentsByGrade();
//		update();
//		delete();
	}
	//��ѧ����ӵ��༶
	public static void add(){
		Grade g=new Grade("javaһ��","java�������һ��");
		Student stu1=new Student("����", "��");
		Student stu2=new Student("����", "Ů");
		//���ϣ����ѧ��������Ӷ�Ӧ�İ༶��ţ���Ҫ�ڰ༶�����ѧ��������������ϵ
		g.getStudents().add(stu1);
		g.getStudents().add(stu2);
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.save(g);
		session.save(stu1);
		session.save(stu2);
		tx.commit();
		HibernateUtil.closeSession(session);
	}
	
	//��ѯ�༶�а�����ѧ��
	public static void findStudentsByGrade(){
		Session session =HibernateUtil.getSession();
		Grade grade=(Grade) session.get(Grade.class, 1);
		System.out.println(grade.getGname()+","+grade.getGdesc());
		
		Set<Student> students=grade.getStudents();
		for (Student student : students) {
			System.out.println(student.getSname()+","+student.getSex());
		}
	
	}
	//�޸�ѧ����Ϣ
	public static void update(){
		Grade g=new Grade("java��������", "java�����������");
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Student stu=(Student) session.get(Student.class, 1);
		g.getStudents().add(stu);
		session.save(g);
		tx.commit();
		HibernateUtil.closeSession(session);
	
	}
	//ɾ��ѧ����Ϣ
	public static void delete(){
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		Student stu=(Student) session.get(Student.class, 2);
		session.delete(stu);
		tx.commit();
		HibernateUtil.closeSession(session);
	}
	
}
