package observermodel2;

import java.util.ArrayList;
import java.util.List;

/**
 * Ŀ�������֪���۲����Ĺ۲��ߣ����ṩע�ᣨ��ӣ���ɾ���۲���Ľӿ�
 * @author Administrator
 *
 */
public class WeatherSubject {
	//��������ע��Ĺ۲��߶���
	private List<Observer> observers=new ArrayList<Observer>();
	//�Ѷ�������������ӵ������ߵ��б���
	public void attach(Observer observer){
		observers.add(observer);
	}
	/**
	 * ɾ�������е�ָ��������������
	 * @param observer
	 */
	public void detach(Observer observer){
		observers.remove(observer);
	}
	/**
	 * ֪ͨ�����Ѿ�������������
	 */
	protected void notifyObservers(){
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
}
