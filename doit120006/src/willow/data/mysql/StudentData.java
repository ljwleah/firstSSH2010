package willow.data.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;

import willow.business.student.StudentListForm;
import willow.data.AbstractBean;
import willow.entity.Student;

/**
 * Filename: StudentData.java
 */
public class StudentData extends AbstractBean implements IStudentData {
	static Logger logger = Logger.getLogger(StudentData.class);

	//@Override
	public List<Student> listStudent(BeanFactory bf, Statement stmt,StudentListForm slf) throws SQLException {
		logger.info(slf.getField());
		logger.info(slf.getCond());
		logger.info(slf.getCriteria());
		
		String cond = "";
		//获得页面传来的保留查询条件，如果该参数为空，则根据输入查询参数生成查询条件。
	    if(!"".equals(slf.getCriteria())){
	      //如果没有选择字段，则对两个字段进行判断
	      if("".equals(slf.getField())){
	        cond = " id like '%" + slf.getCriteria() + "%' or name like '%" + slf.getCriteria() + "%'";
	      }else{ //对选择的字段进行判断
	        cond = slf.getField() + " like '%" + slf.getCriteria() + "%'";
	      }
		  slf.setCond(cond);
	    }else if(!"".equals(slf.getCond())){
	    	cond = slf.getCond();
	    }
	    //将生成的查询条件存回页面
		
		String qrysql = "select id, name, (year(NOW())-year(birthday)) ";
		qrysql = qrysql + "as age,sex,grade,schoolclass,department,major ";
		qrysql = qrysql + "from student ";

		String cntsql = "select count(*) from student ";
		
		if(!"".equals(cond)){
			qrysql = qrysql + "where " + cond;
			cntsql = cntsql + "where " + cond;
		}
		logger.info(cntsql);
		
		ResultSet rs = stmt.executeQuery(cntsql);
		if(rs.next()){
		    int rc = rs.getInt(1);
		    int cc = rc / slf.getPageSizes();
		    if(rc % slf.getPageSizes()==0) cc = cc - 1;
		    slf.setPageCount(cc);
		}
		rs.close();
		
		//指定查询的起始位置和长度
	    qrysql = qrysql + " limit " + slf.getPagePoint() * slf.getPageSizes() + "," + slf.getPageSizes();
		logger.info(qrysql);

		rs = stmt.executeQuery(qrysql);
		List<Student> list = new ArrayList<Student>();
		while(rs.next()){
			Student student = new Student();
			student.setId(rs.getString(1));
			student.setName(rs.getString(2));
			student.setBirthday(rs.getString(3));
			list.add(student);
		}
		rs.close();

		return list;
	}

	@Override
	public Object getPersonById(BeanFactory bf, Statement stmt, String id)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addStudent(BeanFactory bf, Statement stmt, Student student)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveStudent(BeanFactory bf, Statement stmt, Student student)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleStudent(BeanFactory bf, Statement stmt, Student student)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student getStudentById(BeanFactory bf, Statement stmt, String id)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameById(BeanFactory bf, Statement stmt, String id)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
