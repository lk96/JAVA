package observermodel2;

public class Client {

	public static void main(String[] args) {
		//����һ��Ŀ��
		ConcreteWeatherSubject weather=new ConcreteWeatherSubject();
		//�����۲���
		ConcreteObserver observerPeople=new ConcreteObserver();
		observerPeople.setObserverName("����");
		observerPeople.setRemindThing("hello");
		
		ConcreteObserver observerPeople2=new ConcreteObserver();
		observerPeople2.setObserverName("����");
		observerPeople2.setRemindThing("hi");
		//ע��۲���
		weather.attach(observerPeople);
		weather.attach(observerPeople2);
		
		//Ŀ�귢������
		weather.setWeatherContent("��������");
	}

}
