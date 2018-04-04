package observermodel2;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标对象，他知道观察它的观察者，并提供注册（添加）和删除观察这的接口
 * @author Administrator
 *
 */
public class WeatherSubject {
	//用来保存注册的观察者对象
	private List<Observer> observers=new ArrayList<Observer>();
	//把订阅天气的人添加到订阅者的列表中
	public void attach(Observer observer){
		observers.add(observer);
	}
	/**
	 * 删除集合中的指定订阅天气的人
	 * @param observer
	 */
	public void detach(Observer observer){
		observers.remove(observer);
	}
	/**
	 * 通知所有已经订阅天气的人
	 */
	protected void notifyObservers(){
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
}
