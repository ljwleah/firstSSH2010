package willow.dao.c3p0;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 *  Filename:  Test.java
 */
public class C3p0Test {   
	private static ComboPooledDataSource cpds = new ComboPooledDataSource();
	public static void main(String[] args){
		System.out.println(">>>> ");
		try{
			cpds.setDriverClass("org.gjt.mm.mysql.Driver");
			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/hawk");
			cpds.setUser("root");
			cpds.setPassword("123456");
			cpds.setMaxStatements(180);
			cpds.setMaxPoolSize(100);
			
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			con=cpds.getConnection();
			stmt=con.createStatement();
			rs = stmt.executeQuery("select * from student");
			while(rs.next()){
				System.out.println(rs.getString(1));   
			}
			rs.close();
			stmt.close();
			con.close();
			cpds.close();
			cpds = null;
		}catch (Exception e) {   
			e.printStackTrace();   
		}   
	}
}
