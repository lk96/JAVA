package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerDemo implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent servletcontextevent) {
		System.out.println("contextDestroyed");
	}
	@Override
	public void contextInitialized(ServletContextEvent servletcontextevent) {
		String initParam=servletcontextevent.getServletContext().getInitParameter("initParam");
		
		System.out.println("contextInitialized : initParam="+initParam);
	}

}
