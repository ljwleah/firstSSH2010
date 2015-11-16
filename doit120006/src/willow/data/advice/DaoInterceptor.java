package willow.data.advice;

import java.sql.Connection;
import java.sql.Statement;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.BeanFactory;

import willow.dao.IDao;

public class DaoInterceptor implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		Object result = null;
		
		   //如果被建议方法的第一个参数是BeanFactory类型，则执行around建议
	    if(arg0.getArguments()[0] instanceof BeanFactory){
	      //获取第一个BeanFactory类型的参数bf
	      BeanFactory bf = (BeanFactory)arg0.getArguments()[0];
	      
	      //利用传入的bf通过Spring的IoC调用Dao对象
	      IDao dao = (IDao)bf.getBean("dao");
	      //打开数据数据连接
	      dao.openConnection();
	      Connection con = dao.getConnection();
	      Statement stmt = con.createStatement();
	      
	      arg0.getArguments()[1]=stmt;

	      result= arg0.proceed();

	      stmt.close();
	      dao.releaseConnection(con);
	    }

		return result;
	}

}
