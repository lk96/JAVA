package observermodel4;

public class ConcreteWeatherSubject extends WeatherSubject {
	
	//“晴天”  “下雨”  “下雪”
	//目标对象的状态
	private String weatherContent;
	@Override
	protected void notifyObserver() {
		for (Observer observer : observers) {
			//“下雨 通知张三” 其他条件不通知
			//下雨或者下雪通知李四，其他条件不通知
			//如果是晴天 do nothing
			//如果是下雨 
			if ("下雨".equals(this.getWeatherContent())) {
				if ("张三".equals(observer.getObserverName())) {
					observer.update(this);
				}
				if ("李四".equals(observer.getObserverName())) {
					observer.update(this);
				}
			}
			if ("下雪".equals(this.getWeatherContent())) {
				if ("李四".equals(observer.getObserverName())) {
					observer.update(this);
				}
			}
		}
		
	}
	public String getWeatherContent() {
		return weatherContent;
	}
	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
		this.notifyObserver();
	}

}
