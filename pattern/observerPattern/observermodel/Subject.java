package observermodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Ŀ�������֪���۲����Ĺ۲��ߣ����ṩע�ᣨ��ӣ���ɾ���۲���Ľӿ�
 * @author Administrator
 *
 */
public class Subject {
	//��������ע��Ĺ۲��߶���
	private List<Observer> observers=new ArrayList<Observer>();
	public void attach(Observer observer){
		observers.add(observer);
	}
	/**
	 * ɾ�������е�ָ���۲���
	 * @param observer
	 */
	public void detach(Observer observer){
		observers.remove(observer);
	}
	/**
	 * ֪ͨ����ע��Ĺ۲��߶���
	 */
	protected void notifyObservers(){
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
}
