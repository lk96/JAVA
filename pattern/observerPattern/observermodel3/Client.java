package observermodel3;

public class Client {

	public static void main(String[] args) {
		//����������Ϊһ��Ŀ�꣬Ҳ�����Ǳ��۲���
		ConcreteWeatherSubject subject=new ConcreteWeatherSubject();
		//�����۲���1
		ConcreteObserver people=new ConcreteObserver();
		people.setObserverName("����");
		//�����۲���2
		ConcreteObserver people2=new ConcreteObserver();
		people2.setObserverName("����");
		//ע��۲���
		subject.addObserver(people);
		subject.addObserver(people2);
		//Ŀ���������
		subject.setContent("��������");
	}

}
