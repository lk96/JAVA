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
		s.setGender("Ů");
		s.setBirthday(new Date());
		Address address=new Address("111111","888888","����");
		s.setAddress(address);
		
		session.save(s);
		
	}
	/*
	 * get��load������
	 * �ڲ����ǻ��������£�get�������ڵ���֮�����������ݿ���sql��䣬���س־û�����
	 * load�������ڵ��ú󷵻�һ���������
	 * �ô������ֻ������ʵ������idֱ��ʹ�ö���ķ��������ԲŻᷢ��sql���
	 *
	 *��ѯ���ݿⲻ���ڵ�����ʱget��������null
	 *load�����׳��쳣
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
		s.setGender("��");
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
		s.setGender("Ů");
		s.setBirthday(new Date());
		//�Ȼ����Ƭ�ļ�
		File f=new File("e:"+File.separator+"Siri.png");
		//�����Ƭ��������
		InputStream input=new FileInputStream(f);
		Blob image=Hibernate.getLobCreator(session).createBlob(input,input.available());
			//������Ƭ����
		s.setPicture(image);
		session.save(s);
			
	}
	@Test
	public  void testReadBlob() throws IOException, SQLException{
		Students s=(Students) session.get(Students.class,10);
		//���Blob����
		Blob image=s.getPicture();
		//���������
		InputStream input=image.getBinaryStream();
		//���������
		File f=new File("f:"+File.separator+"Siri.png");
		//��������
		OutputStream output=new FileOutputStream(f);
		//����������
		byte[] buff=new byte[input.available()];
		input.read(buff);
		output.write(buff);
		input.close();
		output.close();
	}
	
}
