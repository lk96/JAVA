package observermodel;
/**
 * ����Ĺ۲��߶���ʵ�ָ��µķ�����ʹ�����״̬��Ŀ��״̬����һ��
 * @author Administrator
 *
 */
public class ConcreteObserver implements Observer {
	private String observerState;
	/**
	 * ��ȡĿ����ĵ�״̬ͬ�����۲��ߵ�״̬��
	 */
	@Override
	public void update(Subject subject) {
		observerState=((ConcreteSubject)subject).getSubjectState();
	}

}
