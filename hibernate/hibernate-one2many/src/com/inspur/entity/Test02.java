package com.inspur.entity;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.inspur.util.HibernateUtil;

/*
 * 单向多对一（学生-->班级）
 * 实际上已经建立了双向一对多，也称双向多对一
 * 既可以方便的由学生查找到对应的班级信息，也可以方便的由班级查找到其所包含的学生信息
 */
public class Test02 {
	public static void main(String[] args) {
//		save();
		findGradeByStudent();
	}
	//保存
	public static void save(){
		Grade g=new Grade("java一班","java软件开发一班");
		Student stu1=new Student("张三", "男");
		Student stu2=new Student("李四", "女");
	
		//设置关联关系
		g.getStudents().add(stu1);
		g.getStudents().add(stu2);
		stu1.setGrade(g);
		stu2.setGrade(g);
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.save(g);//级联操作
//		session.save(stu1);
//		session.save(stu2);
		tx.commit();
		HibernateUtil.closeSession(session);
	}
	//查询学生所在班级信息
	public static void findGradeByStudent(){
		Session session=HibernateUtil.getSession();
		Student stu=(Student) session.get(Student.class,2);
		System.out.println(stu.getSid()+","+stu.getSname()+","+stu.getSex());
		Grade g=stu.getGrade();
		System.out.println(g.getGid()+","+g.getGname()+","+g.getGdesc());
	}
	
}
