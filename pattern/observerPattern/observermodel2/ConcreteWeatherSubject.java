package observermodel2;
/**
 * �����Ŀ����󣬸�����й�״̬���뵽��Ӯ�Ĺ۲��߶�����
 * @author Administrator
 *
 */
public class ConcreteWeatherSubject extends WeatherSubject {
	//��ȡ������������Ϣ
	private String weatherContent;

	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
		//�������ˣ�˵�����������ˣ�֪ͨ���еĶ�����
		this.notifyObservers();
	}

	
	
}
