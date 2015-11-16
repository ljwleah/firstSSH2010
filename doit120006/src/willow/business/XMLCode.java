package willow.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import willow.entity.code.Code;

/**
 * Filename: XMLCode.java
 */
public class XMLCode extends HttpServlet {
	private static final long serialVersionUID = -2912363465070002344L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Document document = new Document(new Element("root"));
		response.setContentType("text/xml; charset=UTF-8");
		PrintWriter out = response.getWriter();
		XMLOutputter xout = new XMLOutputter();

		List<Code> list = (List)request.getAttribute("list");
		
		for(int i = 0; i< list.size();i++){
			Element e = new Element("code");
			document.getRootElement().addContent(e);
			Code code = list.get(i);
			
			e.setAttribute("id",code.getId());
			e.setAttribute("name",code.getName());
			e.setAttribute("type",code.getType());
		}

		xout.output(document, out);
		out.close();
	}

	public void destroy() {
		System.out.println("XML Code Servlet Destroied");
		super.destroy();
	}

	public void init() throws ServletException {
		System.out.println("XML Code Servlet loaded!");
		super.init();
	}
}
