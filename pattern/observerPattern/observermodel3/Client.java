package observermodel3;

public class Client {

	public static void main(String[] args) {
		//创建天气作为一个目标，也可以是被观察者
		ConcreteWeatherSubject subject=new ConcreteWeatherSubject();
		//创建观察者1
		ConcreteObserver people=new ConcreteObserver();
		people.setObserverName("张三");
		//创建观察者2
		ConcreteObserver people2=new ConcreteObserver();
		people2.setObserverName("李四");
		//注册观察者
		subject.addObserver(people);
		subject.addObserver(people2);
		//目标更新天气
		subject.setContent("天气晴朗");
	}

}
