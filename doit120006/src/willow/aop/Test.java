package willow.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Filename: Test.java
 */
public class Test {
  public static void main(String[] args) {
    ApplicationContext ctx =new FileSystemXmlApplicationContext("/src/applicationContext.xml");

    IStudent person = (IStudent)ctx.getBean("student");
    person.addStudent("dragon");
    person.addStudent("javadragon");
    }

}

