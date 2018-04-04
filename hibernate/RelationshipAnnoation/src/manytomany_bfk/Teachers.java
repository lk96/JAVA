package manytomany_bfk;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

/*
 * ��ʦʵ����
 */
@Entity
public class Teachers {
	@Id
	@GeneratedValue(generator="tid")
	@GenericGenerator(name="tid",strategy="assigned")
	@Column(length=4)
	private String tid;
	private String tname;
	@ManyToMany(mappedBy="teachers")
	private Set<Students> stus;//��ʦ����ѧ���ļ���
	
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Teachers(String tid, String tname) {
		this.tid = tid;
		this.tname = tname;
	}
	public Teachers() {
	}
	
}