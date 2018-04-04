package observermodel4;

public class Client {

	public static void main(String[] args) {
		// 创建目标
		ConcreteWeatherSubject weathersubject=new ConcreteWeatherSubject();
		//创建观察者
		ConcreteObserver people1=new ConcreteObserver();
		people1.setObserverName("张三");
		people1.setRemindThing("下雨了，安静呆在家里吧");
		
		
		ConcreteObserver people2=new ConcreteObserver();
		people2.setObserverName("李四");
		people2.setRemindThing("不管下雨下雪，我都不出门");
		//注册观察者
		weathersubject.attach(people1);
		weathersubject.attach(people2);
		//目标发布天气
		weathersubject.setWeatherContent("下雨");
		weathersubject.setWeatherContent("下雪");
	}

}
