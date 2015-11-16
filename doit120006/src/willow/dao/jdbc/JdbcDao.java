package willow.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import willow.dao.IDao;

public class JdbcDao implements IDao{
  static Connection conn = null; 

  public void openConnection(){
    try{
      if(conn==null){
        Context initCtx = new InitialContext();  //引入Web资源
        //通过资源建立数据空间
        DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/hawk");
        conn = ds.getConnection();  //获得数据库连接
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  public synchronized Connection getConnection(){
    Connection temp = null;
    if(conn!=null){
      temp=conn;
      conn=null;
      return temp;
    }else{
      return null;
    }
  }

  public synchronized void releaseConnection(Connection con){
    conn=con;
  }

  public void closeConnection(){
    try{
      conn.close();
      conn = null;
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  public void printTest() {
    try {
      System.out.println("getAutoCommit: " + conn.getAutoCommit());
      System.out.println("getCatalog: " + conn.getCatalog());
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

