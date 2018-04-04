package com.inspur.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;


import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.inspur.entity.Address;
import com.inspur.entity.Students;
import com.inspur.util.HibernateUtil;

public class TestStudent {
	private Session session;
	private Transaction tx;
	@Before
	public void ini(){
		 session=HibernateUtil.getSession();
		 tx=session.beginTransaction();
	}
	@After
	public void destory(){
		tx.commit();
		HibernateUtil.closeSession(session);
	}
	@Test
	public  void testSaveStudents(){
		
		Students s=new Students();
		s.setSid(10);
		s.setSname("tony");
		s.setGender("女");
		s.setBirthday(new Date());
		Address address=new Address("111111","888888","北京");
		s.setAddress(address);
		
		session.save(s);
		
	}
	/*
	 * get与load的区别
	 * 在不考虑缓存的情况下，get方法会在调用之后立即向数据库打出sql语句，返回持久化对象
	 * load方法会在调用后返回一个代理对象
	 * 该代理对象只保存了实体对象的id直到使用对象的非主键属性才会发出sql语句
	 *
	 *查询数据库不存在的数据时get方法返回null
	 *load方法抛出异常
	 */
	@Test
	public void testGetStudents(){
		Students s=(Students) session.get(Students.class, 10);
		System.out.println(s.getClass().getName());
		System.out.println(s);
	}
	@Test
	public void testLoadStudents(){
		Students s=(Students) session.load(Students.class, 10);
		System.out.println(s.getClass().getName());
		System.out.println(s);
	}
	@Test
	public void testUpdateStudents(){
		Students s=(Students) session.get(Students.class, 10);
		s.setGender("男");
		session.update(s);
	}
	@Test
	public void testDeleteStudents(){
		Students s=(Students) session.get(Students.class, 10);
		
		session.delete(s);
	}
	

	@Test
	public  void testWriteBlob() throws IOException{
		Students s=new Students();
		s.setSid(10);
		s.setSname("tony");
		s.setGender("女");
		s.setBirthday(new Date());
		//先获得照片文件
		File f=new File("e:"+File.separator+"Siri.png");
		//获得照片的输入流
		InputStream input=new FileInputStream(f);
		Blob image=Hibernate.getLobCreator(session).createBlob(input,input.available());
			//设置照片属性
		s.setPicture(image);
		session.save(s);
			
	}
	@Test
	public  void testReadBlob() throws IOException, SQLException{
		Students s=(Students) session.get(Students.class,10);
		//获得Blob对象
		Blob image=s.getPicture();
		//获得输入流
		InputStream input=image.getBinaryStream();
		//创建输出流
		File f=new File("f:"+File.separator+"Siri.png");
		//获得输出流
		OutputStream output=new FileOutputStream(f);
		//创建缓冲区
		byte[] buff=new byte[input.available()];
		input.read(buff);
		output.write(buff);
		input.close();
		output.close();
	}
	
}
