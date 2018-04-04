package observermodel3;

import java.util.Observable;
//天气目标的具体实现类
public class ConcreteWeatherSubject extends Observable {
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		//天气更新，通知所有观察者
		//注意在通知之前，在java中的Observer模式时候，下面这句话不可少
		this.setChanged();
		//然后主动通知，推方式
		this.notifyObservers(content);
		//拉方式
		//this.notifyObservers();
	}
	
}
