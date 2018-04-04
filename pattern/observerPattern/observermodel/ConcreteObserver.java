package observermodel;
/**
 * 具体的观察者对象，实现更新的方法，使自身的状态和目标状态保持一致
 * @author Administrator
 *
 */
public class ConcreteObserver implements Observer {
	private String observerState;
	/**
	 * 获取目标类的的状态同步到观察者的状态中
	 */
	@Override
	public void update(Subject subject) {
		observerState=((ConcreteSubject)subject).getSubjectState();
	}

}
