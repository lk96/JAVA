package onetoone_fk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import onetoone_bfk.Students;

import org.hibernate.annotations.GenericGenerator;

//身份证类
@Entity
public class IdCard {
	@Id
	@GeneratedValue(generator="pid")
	@GenericGenerator(name="pid",strategy="assigned")
	@Column(length=18)
	private String pid;//身份证号码
	private String sname;//学生的姓名
	@OneToOne(mappedBy="card")
	private Students stu;
	
	public Students getStu() {
		return stu;
	}
	public void setStu(Students stu) {
		this.stu = stu;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public IdCard() {
	}
	public IdCard(String pid, String sname) {
		this.pid = pid;
		this.sname = sname;
	}
	
}
