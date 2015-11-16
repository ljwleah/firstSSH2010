package willow.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

/**
 *  例中使用Context.list()，返回NameClassPair的一个枚举类型的集合。
 *  每个NameClassPair由对象的名字和它的类名组成
 *  
 *  Filename: FileList.java
 */
public class FileList {  
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static void main(String[] args){  
    Hashtable env = new Hashtable(11);  
    //设置JNDI工厂类,指明Service provider是文件系统.  
  
    env.put(Context.INITIAL_CONTEXT_FACTORY
        ,"com.sun.jndi.fscontext.RefFSContextFactory");
    //设置JNDI文件路径  
    //操作相对程序运行的盘的根目录
        env.put(Context.PROVIDER_URL, "file:/c:/");  
        try {  
            Context ctx = new InitialContext(env);  
            //初始化上下文  
            NamingEnumeration list = ctx.list("Program Files");  
            while (list.hasMore()) {  
                NameClassPair ne = (NameClassPair) list.next();  
                System.out.println(ne.getName());  
            }  
            ctx.close();  
        } catch (NamingException e) {  
            System.err.println("List failed: " + e);  
        }  
    }  
} 
