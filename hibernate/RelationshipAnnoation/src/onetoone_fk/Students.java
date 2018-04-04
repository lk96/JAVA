package onetoone_fk;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;/*JPA注解*/
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

/*
 * 学生实体类
 */

@Entity
public class Students {
	@Id
	@GeneratedValue
	private int sid;
	private IdCard card;
	private String gender;
	private Date birthday;
	private String major;

	public Students() {
	}

	public Students(IdCard card,  String gender, Date birthday,
			String major) {
		this.card=card;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
	}
	@Id
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
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
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pid",unique=true)
	public IdCard getCard() {
		return card;
	}

	public void setCard(IdCard card) {
		this.card = card;
	}
	
	
	

}
