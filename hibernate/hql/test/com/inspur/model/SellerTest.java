package com.inspur.model;


import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.inspur.util.HibernateSessionFactory;

public class SellerTest {
	private Session session= null;
	
	
	
	
	
	@Test
	public void testSelectClauseSelf(){
		String hql = " select new Seller(s.name,s.tel,s.address) from Seller s ";
		Query query = session.createQuery(hql);
		List<Seller> sellers = query.list();
		
		for(Seller seller : sellers){
			System.out.println("name: "+seller.getName());
			System.out.println("tel:"+seller.getTel());
			System.out.println("address:"+seller.getAddress());
		}
	}
	
	
	@Test
	public void testSeller(){
		String hql="from Seller seller";
		Query query= session.createQuery(hql);
		List<Seller> sellers= query.list();
		for (Seller seller : sellers) {
			System.out.println(seller);
		}
	}
	/*
	 * 1.name2.tel.address4.star
	 */
	@Test
	public void testSelectClauseObjectArray(){
		String hql="select s.name,s.tel,s.address,s.star from Seller s";
		Query query= session.createQuery(hql);
		List<Object[]> list= query.list(); 
		for (Object[] objs : list) {
			System.out.println("name"+objs[0]);
			System.out.println("tel"+objs[1]);
			System.out.println("address"+objs[2]);
			System.out.println("star"+objs[3]);
		}
	}
	@Test
	public void testSelectClauseList(){
		String hql="select new list(s.name as name,s.tel as tel,s.address as address) from Seller s";
		Query query= session.createQuery(hql);
		List<List> lists= query.list(); 
		for (List list : lists) {
			System.out.println("name:"+list.get(0));
			System.out.println("tel:"+list.get(1));
			System.out.println("address:"+list.get(2));
		}
	}
	@Test
	public void testSelectClauseMap(){
		String hql="select new Map(s.name,s.tel,s.address) from Seller s";
		Query query= session.createQuery(hql);
		List<Map> maps= query.list(); 
		for (Map map : maps) {
			System.out.println("name:"+map.get("name"));
			System.out.println("tel:"+map.get("1"));
			System.out.println("address:"+map.get("2"));
		}
	}
	
	@Before
	public void setUp() throws Exception {
	session=HibernateSessionFactory.getCurrentSession();
	
	}

	@After
	public void tearDown() throws Exception {
	session.close();
	
	}

	

}
