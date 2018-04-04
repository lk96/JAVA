package manytomany_bfk;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


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
	private Set<Teachers> teachers;//学生持有教师集合
	
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
	@ManyToMany
	@JoinTable(name="teachers_students",
		joinColumns={@JoinColumn(name="sid")},
		inverseJoinColumns={@JoinColumn(name="tid")}
			)
	public Set<Teachers> getTeachers() {
		return teachers;
	}
	
	public void setTeachers(Set<Teachers> teachers) {
		this.teachers = teachers;
	}
	
	
	
	

}
