package willow;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.WebApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
/**
 * Filename: BaseActionSupport.java
 */
public class BaseActionSupport extends ActionSupport {
	private static final long serialVersionUID = 5682936451837547362L;

	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public HttpSession getSession() {
		return getRequest().getSession();
	}

	public ServletContext getContext(){
		return (ServletContext)getSession().getServletContext();
	}

	public BeanFactory getBeanFactory(HttpSession session){
		ServletContext context = (ServletContext)session.getServletContext();
		return (BeanFactory)context.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	}

	public BeanFactory getBeanFactory(){
		ServletContext context = (ServletContext)getSession().getServletContext();
		return (BeanFactory)context.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	}

}