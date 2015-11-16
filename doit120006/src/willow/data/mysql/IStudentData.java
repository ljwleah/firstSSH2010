package willow.data.mysql;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;

import willow.business.student.StudentListForm;
import willow.entity.Student;

/**
 * Filename: IStudentData.java
 */
public interface IStudentData extends IPerson{
	public void addStudent(BeanFactory bf,Statement stmt,Student student) throws SQLException;
	public void saveStudent(BeanFactory bf,Statement stmt,Student student) throws SQLException;
	public void deleStudent(BeanFactory bf,Statement stmt,Student student) throws SQLException;
	public List<Student> listStudent(BeanFactory bf,Statement stmt,StudentListForm slf) throws SQLException;
	public Student getStudentById(BeanFactory bf,Statement stmt,String id) throws SQLException;
	public String getNameById(BeanFactory bf,Statement stmt,String id) throws SQLException;
}
