package observermodel2;

import observermodel.ConcreteSubject;

/**
 * ����Ĺ۲��߶���ʵ�ָ��µķ�����ʹ�����״̬��Ŀ��״̬����һ��
 * @author Administrator
 *
 */
public class ConcreteObserver implements Observer {
	//�۲��ߵ�����
	private String observerName;
	//�������ݵ�����������Ϣ��Ŀ�괦��ȡ
	private String weatherContent;
	//���ѵ�����
	private String remindThing;
	/**
	 * ��ȡĿ����ĵ�״̬ͬ�����۲��ߵ�״̬��
	 */
	@Override
	public void update(WeatherSubject subject) {
		weatherContent=((ConcreteWeatherSubject)subject).getWeatherContent();
		System.out.println(observerName+"�յ���"+weatherContent+","+remindThing);
	}
	public String getObserverName() {
		return observerName;
	}
	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}
	public String getWeatherContent() {
		return weatherContent;
	}
	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
	}
	public String getRemindThing() {
		return remindThing;
	}
	public void setRemindThing(String remindThing) {
		this.remindThing = remindThing;
	}
	
}
