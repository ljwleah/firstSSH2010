package willow.data.mysql;

import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.BeanFactory;

import willow.data.IBeanFactory;

/**
 * Filename: IPerson.java
 */
public interface IPerson extends IBeanFactory {
	public Object getPersonById(BeanFactory bf,Statement stmt,String id) throws SQLException;
}
