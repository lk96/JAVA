package onetomany_bfk;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

/*
 * �༶ʵ����
 */
@Entity
public class ClassRoom {
	
	@Id
	@GeneratedValue(generator="cid")
	@GenericGenerator(name="cid",strategy="assigned")
	@Column(length=4)
	private String cid;
	private String cname;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="cid")
	private Set<Students> stus;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public ClassRoom(String cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}
	public ClassRoom() {
	}
	public Set<Students> getStus() {
		return stus;
	}
	public void setStus(Set<Students> stus) {
		this.stus = stus;
	}
	
}
