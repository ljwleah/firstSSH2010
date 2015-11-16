package willow.dao;

import java.sql.Connection;

/**
 * Filename: IDao.java
 */
public interface IDao {
	public void openConnection();
	public Connection getConnection();
	public void releaseConnection(Connection con);
	public void closeConnection();
	public void printTest();
}
