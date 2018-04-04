package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class HttpSessionAttributeListenerDemo implements
		HttpSessionAttributeListener {
	@Override
	public void attributeAdded(HttpSessionBindingEvent httpsessionbindingevent) {
		System.out.println("HttpSession_attributeAdded:"+httpsessionbindingevent.getName());
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent httpsessionbindingevent) {
		System.out.println("HttpSession_attributeRemoved:"+httpsessionbindingevent.getName());
	}
	@Override
	public void attributeReplaced(HttpSessionBindingEvent httpsessionbindingevent) {
		System.out.println("HttpSession_attributeReplaced:"+httpsessionbindingevent.getName());
	}

}
