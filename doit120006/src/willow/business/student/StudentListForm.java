package willow.business.student;

import willow.PageForm;

/**
 * Filename:  StudentListForm.java
 */
public class StudentListForm extends PageForm {
	private static final long serialVersionUID = -8790336681281046599L;
	
	private String field="";
	private String criteria="";
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = replaceSQL(criteria);
	}

}
