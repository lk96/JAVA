package listener;

import javax.servlet.http.HttpSessionEvent;

public class HttpSessionListener implements
		javax.servlet.http.HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent httpsessionevent) {
		System.out.println("sessionCreated");
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent httpsessionevent) {
		System.out.println("sessionDestroyed");
	}

}
