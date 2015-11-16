package willow.business;

import willow.BaseAbstractAction;

/**
 *  Filename: CodeForm.java
 */
public class CodeForm extends BaseAbstractAction {
	private static final long serialVersionUID = 8149513724953689280L;

	private String upid = "";
	private String code = "";
	
	public String getUpid() {
		return upid;
	}
	public void setUpid(String upid) {
		this.upid = upid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
