package observermodel4;

public class ConcreteWeatherSubject extends WeatherSubject {
	
	//�����족  �����ꡱ  ����ѩ��
	//Ŀ������״̬
	private String weatherContent;
	@Override
	protected void notifyObserver() {
		for (Observer observer : observers) {
			//������ ֪ͨ������ ����������֪ͨ
			//���������ѩ֪ͨ���ģ�����������֪ͨ
			//��������� do nothing
			//��������� 
			if ("����".equals(this.getWeatherContent())) {
				if ("����".equals(observer.getObserverName())) {
					observer.update(this);
				}
				if ("����".equals(observer.getObserverName())) {
					observer.update(this);
				}
			}
			if ("��ѩ".equals(this.getWeatherContent())) {
				if ("����".equals(observer.getObserverName())) {
					observer.update(this);
				}
			}
		}
		
	}
	public String getWeatherContent() {
		return weatherContent;
	}
	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
		this.notifyObserver();
	}

}
