package willow.dao.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import willow.dao.IDao;

/**
 *  Filename:  DbpcDao.java
 */
public class DbcpDao implements IDao{

  private static BasicDataSource bds = null;
  
  public void openConnection(){
    try{
      if(bds==null){
        Context initCtx = new InitialContext();  //引入Web资源
        //通过资源建立数据空间
        bds = (BasicDataSource)initCtx.lookup("java:comp/env/jdbc/hawk");
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  public synchronized Connection getConnection(){
    Connection temp = null;
    try {
      temp = bds.getConnection();
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
    try {
      bds.close();
      bds = null;
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public void printTest(){
    if(bds!=null){
        System.out.println("getInitialSize: " + bds.getInitialSize());
        System.out.println("getNumActive: " + bds.getNumActive());
        System.out.println("getMaxIdle: " + bds.getMaxIdle());
        System.out.println("getMinIdle: " + bds.getMinIdle());
        System.out.println("getNumIdle: " + bds.getNumIdle());
        System.out.println("getRemoveAbandoned: " + bds.getRemoveAbandoned());
        System.out.println("getRemoveAbandonedTimeout: " + bds.getRemoveAbandonedTimeout());
        System.out.println("getDefaultAutoCommit: " + bds.getDefaultAutoCommit());
        System.out.println("getDefaultAutoCommit: " + bds.getDefaultAutoCommit());
    }else{
      System.out.println("bds is null");
    }
  }
}

