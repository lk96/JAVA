package onetomany_fk;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;/*JPA注解*/
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

/*
 * 学生实体类
 */

@Entity
public class Students {
	private String sid;
	private String sname;
	private String gender;
	private Date birthday;
	private String major;
	public Students() {
	}

	public Students(String sid,String sname,String gender, Date birthday,
			String major) {
		this.sid=sid;
		this.sname=sname;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
	}
	@Id
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
	
	

}
