package observermodel;
/**
 * �����Ŀ����󣬸�����й�״̬���뵽��Ӯ�Ĺ۲��߶�����
 * @author Administrator
 *
 */
public class ConcreteSubject extends Subject {
	//Ŀ�����״̬
	private String subjectState;

	public String getSubjectState() {
		return subjectState;
	}

	public void setSubjectState(String subjectState) {
		this.subjectState = subjectState;
		this.notifyObservers();
	}
	
}
