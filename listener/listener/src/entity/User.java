package entity;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class User implements HttpSessionBindingListener ,HttpSessionActivationListener,Serializable{
	 
	private String username;
	private String password;
	@Override
	public void valueBound(HttpSessionBindingEvent httpsessionbindingevent) {
		System.out.println("valueBound Name:"+httpsessionbindingevent.getName());
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent httpsessionbindingevent) {
		System.out.println("valueUnbound Name:"+httpsessionbindingevent.getName());
	}

	//ป๎ปฏ
	@Override
	public void sessionDidActivate(HttpSessionEvent httpsessionevent) {
		System.out.println("sessionDidActivate"+httpsessionevent.getSource());
	}
	//ถÛปฏ
	@Override
	public void sessionWillPassivate(HttpSessionEvent httpsessionevent) {
		System.out.println("sessionWillPassivate"+httpsessionevent.getSource());
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
