package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ServletContextAttributeListenerDemo implements
		ServletContextAttributeListener {
	@Override
	public void attributeAdded(ServletContextAttributeEvent servletcontextattributeevent) {
		System.out.println("ServletContext_attributeAdded:"+servletcontextattributeevent.getName());
	}
	@Override
	public void attributeRemoved(ServletContextAttributeEvent servletcontextattributeevent) {
		System.out.println("ServletContext_attributeRemoved:"+servletcontextattributeevent.getName());
	}
	@Override
	public void attributeReplaced(ServletContextAttributeEvent servletcontextattributeevent) {
		System.out.println("ServletContext_attributeReplaced:"+servletcontextattributeevent.getName());
	}

}
