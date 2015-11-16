package willow.business;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;

import willow.data.code.ICodeData;
import willow.entity.code.Code;

/**
 * Filename: CodeAction.java
 */
public class CodeAction extends CodeForm {

	private static final long serialVersionUID = 5371213145339553692L;
	static Logger logger = Logger.getLogger(CodeAction.class);
	
	public String execute() throws Exception {
		String input = INPUT;

		CodeForm cf = new CodeForm();
		cf.setCode(getCode());
		cf.setUpid(getUpid());

		BeanFactory bf = (BeanFactory)getBeanFactory();
		ICodeData cd = (ICodeData)bf.getBean("codedata");
		List<Code> list = cd.getCodes(bf,null,cf);
		logger.info(list.size());

		getRequest().setAttribute("list", list);
		input = SUCCESS;
		return input;
	}
}
