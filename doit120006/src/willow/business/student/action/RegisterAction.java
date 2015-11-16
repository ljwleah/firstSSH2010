package willow.business.student.action;

import org.apache.log4j.Logger;

import willow.business.student.RegisterForm;

/**
 * Filename:  RegisterAction.java
 */
public class RegisterAction extends RegisterForm {
	private static final long serialVersionUID = 3503709704516689160L;
	static Logger logger = Logger.getLogger(RegisterAction.class);

	public String execute(){
		String result = INPUT;
		
		System.out.println("世界你好，我来了，这是我的第一个Action，没做什么就是打个招呼！");
		logger.info(super.getSex());
		logger.info(super.getStudentId());
		logger.info(super.getBirthday());

		return result;
	}
}