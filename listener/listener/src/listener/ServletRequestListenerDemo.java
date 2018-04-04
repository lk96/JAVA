package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ServletRequestListenerDemo implements ServletRequestListener {
	@Override
	public void requestDestroyed(ServletRequestEvent servletrequestevent) {
		System.out.println("requestDestroyed");
	}
	@Override
	public void requestInitialized(ServletRequestEvent servletrequestevent) {
		String name=servletrequestevent.getServletRequest().getParameter("name");
		System.out.println("requestInitialized name="+name);
	}

}
