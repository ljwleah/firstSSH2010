package willow.dao.dbcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

/**
 * Test.java
 */
public class DbcpTest {  
    private static DataSource dataSource;
    private static Connection con;

    public static void main(String[] args){
    	getConnection();
    }
    
    public static Connection getConnection(){
        if (dataSource == null){
            initDataSource();  
        }  
        try {  
            con = dataSource.getConnection();  
            print();  
        } catch (SQLException e){
            e.printStackTrace();
        }  
        return con;
    }
    
    public static  void initDataSource(){
        FileInputStream is=null;
        InputStream in = null;
        Properties p = new Properties();

        String driverClassName=null;
        String url=null;
        String username=null;
        String password=null;
        int initialSize=0;
        int minIdle=0;
        int maxIdle=0;
        int maxWait=0;
        int maxActive=0;
        
        try {
        	in = ClassLoader.getSystemResourceAsStream("dbcp.properties");
        	p.load(in);
            driverClassName = p.getProperty("dbcp.driverClassName");
            url = p.getProperty("dbcp.url");
            username = p.getProperty("dbcp.username");
            password = p.getProperty("dbcp.password");
  
            initialSize = Integer.parseInt(p.getProperty("dbcp.initialSize"));
            minIdle = Integer.parseInt(p.getProperty("dbcp.minIdle"));
            maxIdle = Integer.parseInt(p.getProperty("dbcp.maxIdle"));
            maxWait = Integer.parseInt(p.getProperty("dbcp.maxWait"));
            maxActive = Integer.parseInt(p.getProperty("dbcp.maxActive"));
        } catch (NumberFormatException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally{
            try {
                //is.close();
            	in.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(url);
        ds.setDriverClassName(driverClassName);
        ds.setUsername(username);
        ds.setPassword(password);
          
        ds.setInitialSize(initialSize); // 初始的连接数；
        ds.setMaxActive(maxActive);
        ds.setMinIdle(minIdle);
        ds.setMaxIdle(maxIdle);
        ds.setMaxWait(maxWait);
        //ds.setRemoveAbandoned(true);
        //ds.setRemoveAbandonedTimeout(2000);
  
        dataSource = ds;
    }
    
    /* 用于测试连接状态的方法*/  
    public static void print(){  
    	BasicDataSource ds=(BasicDataSource)dataSource;
      
    	System.out.println(ds.getInitialSize());
    	System.out.println(ds.getNumActive());
    	System.out.println(ds.getMaxIdle());
    	System.out.println(ds.getMinIdle());
    	System.out.println(ds.getNumIdle());
    	System.out.println(ds.getRemoveAbandoned());
    	System.out.println(ds.getRemoveAbandonedTimeout());
    	System.out.println(ds.getDefaultAutoCommit());
    	System.out.println(ds.getDefaultAutoCommit());
    }  

}
