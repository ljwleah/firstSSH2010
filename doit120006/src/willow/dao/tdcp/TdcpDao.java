package willow.dao.tdcp;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.tomcat.jdbc.pool.DataSource;

import willow.dao.IDao;

/**
 *  Filename:  TdcpDao.java
 */
public class TdcpDao implements IDao{

  private static DataSource ds = null;
  
  public void openConnection(){
    try{
      if(ds==null){
        Context initCtx = new InitialContext();  //引入Web资源
        //通过资源建立数据空间
        ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/hawk");
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  public synchronized Connection getConnection(){
    Connection temp = null;
    try {
      temp = ds.getConnection();
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
    ds.close();
    ds = null;
  }
  
  public void printTest(){
    if(ds!=null){
          System.out.println("getUrl: " + ds.getUrl());
          System.out.println("getDriverClassName: " + ds.getDriverClassName());
          System.out.println("getUsername: " + ds.getUsername());
          System.out.println("getPassword: " + ds.getPassword());
          System.out.println("isJmxEnabled: " + ds.isJmxEnabled());
          System.out.println("isTestWhileIdle: " + ds.isTestWhileIdle());
          System.out.println("isTestOnBorrow: " + ds.isTestOnBorrow());
          System.out.println("getValidationQuery: " + ds.getValidationQuery());
          System.out.println("isTestOnReturn: " + ds.isTestOnReturn());
          System.out.println("getValidationInterval: " + ds.getValidationInterval());
          System.out.println("getTimeBetweenEvictionRunsMillis: " + ds.getTimeBetweenEvictionRunsMillis());
          System.out.println("getMaxActive: " + ds.getMaxActive());
          System.out.println("getInitialSize: " + ds.getInitialSize());
          System.out.println("getMaxWait: " + ds.getMaxWait());
          System.out.println("getRemoveAbandonedTimeout: " + ds.getRemoveAbandonedTimeout());
          System.out.println("getMinEvictableIdleTimeMillis: " + ds.getMinEvictableIdleTimeMillis());
          System.out.println("getMinIdle: " + ds.getMinIdle());
          System.out.println("isLogAbandoned: " + ds.isLogAbandoned());
          System.out.println("isRemoveAbandoned: " + ds.isRemoveAbandoned());
          System.out.println("getJdbcInterceptors: " + ds.getJdbcInterceptors());
    }else{
      System.out.println("bds is null");
    }
  }
}

