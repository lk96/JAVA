package observermodel4;

//����һ�����µĽӿڷ�������Щ��Ŀ�귢���ı��ʱ��֪ͨ�Ĺ۲��߶������
public interface Observer {
	// ���µĽӿ�
	public void update(WeatherSubject subject);

	// ���¹۲�������
	public void setObserverName(String observerName);

	// ȡ�ù۲�������
	public String getObserverName();
}
