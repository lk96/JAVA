package action;

import java.util.List;
import java.util.Map;

import dao.UserDAO;
import entity.User;


public class UserAction {

	public void add(User goddess) throws Exception{
		UserDAO dao=new UserDAO();
		goddess.setSex(1);
		goddess.setCreate_user("ADMIN");
		goddess.setUpdate_user("ADMIN");
		goddess.setIsdel(0);
		dao.addUser(goddess);
	}
	
	public User get(Integer id) throws Exception{
		UserDAO dao=new UserDAO();
		return dao.get(id);
	}
	
	public void edit(User goddess) throws Exception{
		UserDAO dao=new UserDAO();
		dao.updateUser(goddess);
	}
	public void del(Integer id) throws Exception{
		UserDAO dao=new UserDAO();
		dao.delUser(id);
	}
	
	public List<User>  query() throws Exception{
		UserDAO dao=new UserDAO();
		return dao.query();
	}
	public List<User> query(List<Map<String, Object>> params) throws Exception{
		UserDAO dao=new UserDAO();
		return dao.query(params);
	}
}
