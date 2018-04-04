package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import action.UserAction;

import entity.User;


public class TestAction {

	public static void main(String[] args) throws Exception {
		UserAction action=new UserAction();
		/*查询*/
		User g=new User();
		g.setUser_name("小青");
		g.setSex(1);
		g.setAge(25);
		g.setBirthday(new Date());
		g.setEmail("xiaoqing@163.com");
		g.setMobile("15688888888");
		g.setIsdel(0);
		g.setId(7);
		action.add(g);
		
		//action.edit(g);
		
		//action.del(7);
		
		List<Map<String, Object>> params=new ArrayList<Map<String,Object>>();
		
		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("name", "user_name");
		map.put("rela", "=");
		map.put("value", "'小美'");
		
		params.add(map);
		
		List<User> result=action.query(params);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getId()+
					":"+result.get(i).getUser_name());
		}
	}
}
