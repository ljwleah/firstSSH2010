package willow.dao.c3p0;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;

import willow.dao.IDao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 *  Filename:  C3p0Dao.java
 */
public class C3p0Dao implements IDao{

  private static ComboPooledDataSource cpds = null;
  
  public void openConnection(){
    try{
      if(cpds==null){
        Context initCtx = new InitialContext();  //引入Web资源
        //通过资源建立数据空间
        cpds = (ComboPooledDataSource)initCtx.lookup("java:comp/env/jdbc/hawk");
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  public synchronized Connection getConnection(){
    Connection temp = null;
    try {
      temp = cpds.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }   
    return temp;
  }
   
  public synchronized void releaseConnection(Connection con){
    try {
      con.close();
      con = null;
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public void closeConnection(){
    cpds.close();
    cpds = null;
  }
  
  public void printTest(){
    if(cpds!=null){
      System.out.println("getAcquireIncrement: " + cpds.getAcquireIncrement());
      System.out.println("getMaxStatements: " + cpds.getMaxStatements());
      System.out.println("getMaxPoolSize: " + cpds.getMaxPoolSize());
      System.out.println("getAcquireIncrement: " + cpds.getAcquireIncrement());
      System.out.println("getIdleConnectionTestPeriod: " + cpds.getIdleConnectionTestPeriod());
      System.out.println("getCheckoutTimeout: " + cpds.getCheckoutTimeout());
      System.out.println("getMinPoolSize: " + cpds.getMinPoolSize());
      System.out.println("getMaxIdleTime: " + cpds.getMaxIdleTime());
      System.out.println("isAutoCommitOnClose: " + cpds.isAutoCommitOnClose());
      System.out.println("isTestConnectionOnCheckout: " + cpds.isTestConnectionOnCheckout());
      System.out.println("isTestConnectionOnCheckin: " + cpds.isTestConnectionOnCheckin());
      System.out.println("getAcquireRetryAttempts: " + cpds.getAcquireRetryAttempts());
      System.out.println("getAcquireRetryDelay: " + cpds.getAcquireRetryDelay());
      System.out.println("isBreakAfterAcquireFailure: " + cpds.isBreakAfterAcquireFailure());
    }else{
      System.out.println("cpds is null");
    }
  }
}
