package observermodel3;

import java.util.Observable;
import java.util.Observer;
//����Ĺ۲��߶���
public class ConcreteObserver implements Observer {
	//�۲������Ʊ���
	private String observerName;
	@Override
	public void update(Observable o, Object arg) {
		//��һ���Ʒ�ʽ
		System.out.println(observerName+"�յ�����Ϣ��Ŀ�����͹�������"+arg);
		//����ʽ
		System.out.println(observerName+"�յ�����Ϣ��������Ŀ�������ȥ��������������"+((ConcreteWeatherSubject)o).getContent());
	}
	public String getObserverName() {
		return observerName;
	}
	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}
	

}
