package observermodel;
/**
 * 具体的目标对象，负责把有关状态存入到想赢的观察者对象中
 * @author Administrator
 *
 */
public class ConcreteSubject extends Subject {
	//目标对象状态
	private String subjectState;

	public String getSubjectState() {
		return subjectState;
	}

	public void setSubjectState(String subjectState) {
		this.subjectState = subjectState;
		this.notifyObservers();
	}
	
}
