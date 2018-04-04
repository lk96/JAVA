package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class ServletRequestAttributeListenerDemo implements
		ServletRequestAttributeListener {
	@Override
	public void attributeAdded(ServletRequestAttributeEvent servletrequestattributeevent) {
		System.out.println("ServletRequest_attributeAdded:"+servletrequestattributeevent.getName());
	}
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent servletrequestattributeevent) {
		System.out.println("ServletRequest_attributeRemoved:"+servletrequestattributeevent.getName());
	}
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent servletrequestattributeevent) {
		System.out.println("ServletRequest_attributeReplaced:"+servletrequestattributeevent.getName());
	}

}
