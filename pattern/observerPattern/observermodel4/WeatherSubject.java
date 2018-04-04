package observermodel4;

import java.util.ArrayList;
import java.util.List;



public abstract class WeatherSubject {
	//��������ע��Ĺ۲��߶���
	public List<Observer> observers=new ArrayList<Observer>();
	//�Ѷ����������ˡ��۲�����ӵ��������б���
	public void attach(Observer observer){
		observers.add(observer);
	}
	
	//ɾ��������ָ���Ķ�����������
	public void detach(Observer observer){
		observers.remove(observer);
	}
	protected abstract void notifyObserver();
}
