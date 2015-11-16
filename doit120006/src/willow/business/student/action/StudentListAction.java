package willow.business.student.action;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;

import willow.PageForm;
import willow.business.student.StudentListForm;
import willow.dao.IDao;
import willow.data.mysql.IStudentData;
import willow.entity.Student;

/**
 * Filename:  StudentListAction.java
 */
public class StudentListAction extends StudentListForm {
	private static final long serialVersionUID = 3503709704516689160L;
	static Logger logger = Logger.getLogger(StudentListAction.class);

	public String execute(){
		String result = INPUT;
		
		StudentListForm slf = new StudentListForm();
		slf.setCond(getCond());
		slf.setFunc(getFunc());
		slf.setPageCount(getPageCount());
		slf.setPagePoint(getPagePoint());
		slf.setPageSizes(getPageSizes());
		slf.setField(getField());
		slf.setCriteria(getCriteria());
		
		BeanFactory bf = (BeanFactory)getBeanFactory();
		IStudentData sd = (IStudentData)bf.getBean("studentdata");
		
		try {
			List<Student> list = (List<Student>)sd.listStudent(bf,null,slf);
			getRequest().setAttribute("slf", slf);
			getRequest().setAttribute("list",list);
			result = SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}