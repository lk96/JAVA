package observermodel2;

public class Client {

	public static void main(String[] args) {
		//创建一个目标
		ConcreteWeatherSubject weather=new ConcreteWeatherSubject();
		//创建观察者
		ConcreteObserver observerPeople=new ConcreteObserver();
		observerPeople.setObserverName("张三");
		observerPeople.setRemindThing("hello");
		
		ConcreteObserver observerPeople2=new ConcreteObserver();
		observerPeople2.setObserverName("李四");
		observerPeople2.setRemindThing("hi");
		//注册观察者
		weather.attach(observerPeople);
		weather.attach(observerPeople2);
		
		//目标发布天气
		weather.setWeatherContent("天气晴朗");
	}

}
