package observermodel4;

public class Client {

	public static void main(String[] args) {
		// ����Ŀ��
		ConcreteWeatherSubject weathersubject=new ConcreteWeatherSubject();
		//�����۲���
		ConcreteObserver people1=new ConcreteObserver();
		people1.setObserverName("����");
		people1.setRemindThing("�����ˣ��������ڼ����");
		
		
		ConcreteObserver people2=new ConcreteObserver();
		people2.setObserverName("����");
		people2.setRemindThing("����������ѩ���Ҷ�������");
		//ע��۲���
		weathersubject.attach(people1);
		weathersubject.attach(people2);
		//Ŀ�귢������
		weathersubject.setWeatherContent("����");
		weathersubject.setWeatherContent("��ѩ");
	}

}
