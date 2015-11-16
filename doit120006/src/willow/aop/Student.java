package willow.aop;

/**
 * Filename: StudentTarget.java
 */
public class Student implements IStudent{

  public void addStudent(String name){
    System.out.println( " 欢迎  " + name + "  你加入Spring家庭! " );
  }

}
