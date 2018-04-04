package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.DBHelper;
import entity.User;



public class UserDAO {

	public void addUser(User g) throws Exception{
		Connection conn=DBHelper.getConnection();
		String sql="" +
				" insert into userinfo" +
				" (user_name,sex,age,birthday,email,mobile," +
				" create_user,create_date,update_user,update_date,isdel)" +
				" values(" +
				" ?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getCreate_user());
		ptmt.setDate(8, new Date((new java.util.Date()).getTime()));
		ptmt.setString(9, g.getUpdate_user());
		ptmt.setDate(10, new Date((new java.util.Date()).getTime()));
		ptmt.setInt(11, g.getIsdel());
		ptmt.execute();
	}
	
	public void updateUser(User g) throws Exception{
		Connection conn=DBHelper.getConnection();
		String sql=" update userinfo set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?,update_user=?,update_date=?,isdel=? where id=? ;";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt(2, g.getSex());
		ptmt.setInt(3, g.getAge());
		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getUpdate_user());
		ptmt.setDate(8, new Date((new java.util.Date()).getTime()));
		ptmt.setInt(9, g.getIsdel());
		ptmt.setInt(10, g.getId());
		ptmt.execute();
	}
	
	public void delUser(Integer id) throws Exception{
		Connection conn=DBHelper.getConnection();
		String sql="" +
				" delete from userinfo " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ptmt.execute();
	}
	public List<User> query() throws Exception{
		List<User> result=new ArrayList<User>();
		
		Connection conn=DBHelper.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select id,user_name,age from userinfo  ");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		ResultSet rs=ptmt.executeQuery();
		
		User g=null;
		while(rs.next()){
			g=new User();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			result.add(g);
		}
		return result;
	}
	public List<User> query(String name,String mobile,String email) throws Exception{
		List<User> result=new ArrayList<User>();
		
		Connection conn=DBHelper.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from userinfo  ");
		
		sb.append(" where user_name like ? and mobile like ? and email like ?");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		ptmt.setString(1, "%"+name+"%");
		ptmt.setString(2, "%"+mobile+"%");
		ptmt.setString(3, "%"+email+"%");
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
		User g=null;
		while(rs.next()){
			g=new User();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setIsdel(rs.getInt("isdel"));
			
			result.add(g);
		}
		return result;
	}
	public List<User> query(List<Map<String, Object>> params) throws Exception{
		List<User> result=new ArrayList<User>();
		
		Connection conn=DBHelper.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from userinfo where 1=1 ");
		
		if(params!=null&&params.size()>0){
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map=params.get(i);
				sb.append(" and  "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
			}
		}
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
		User g=null;
		while(rs.next()){
			g=new User();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setIsdel(rs.getInt("isdel"));
			
			result.add(g);
		}
		return result;
	}
	public User get(Integer id) throws Exception{
		User g=null;
		Connection conn=DBHelper.getConnection();
		String sql="" +
				" select * from userinfo " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			g=new User();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setIsdel(rs.getInt("isdel"));
		}
		return g;
	}
}
