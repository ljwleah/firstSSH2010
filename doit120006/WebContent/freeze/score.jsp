<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="willow.dao.*" 
    import="willow.dao.c3p0.*"
    import="java.sql.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
  "http://www.w3.org/TR/html4/loose.dtd">
<!-- Filename: score.jsp -->
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>项目冻结评价</title>
  </head>
  <body>
  <table><caption>学期作业项目里程碑冻结评价成绩</caption>
  <thead><tr  bgcolor='#e0e0e0'>
    <th>序号</th><th>学号</th><th>姓名</th><th>里程碑A</th><th>里程碑B</th>
    <th>里程碑C</th><th>里程碑D</th><th>里程碑E</th><th>里程碑F</th><th>里程碑G</th>
    <th>里程碑H</th><th>里程碑I</th><th>里程碑J</th><th>里程碑K</th><th>里程碑L</th>
    <th>里程碑M</th><th>里程碑N</th><th>成绩汇总</th>
  </tr></thead><tbody>
  <%
    IDao dao = new C3p0Dao();
    dao.openConnection();
    Connection con = dao.getConnection();

    String sql = "select student,name,m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,";
    sql = sql + "m14,m15,m16,m17 from d_hawk_freeze_score";

    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    int i = 1;
    while(rs.next()){
    	  if(i%2==0)
    		  out.print("<tr bgcolor='#e0e0e0'><td>");
    	  else
    	    out.print("<tr bgcolor='#e0ffe0'><td>");
    	  out.print(i);
        out.print("</td><td>");
    	  out.print(rs.getString(1));
        out.print("</td><td>");
        out.print(rs.getString(2));
        out.print("</td><td>");
        float m1 = rs.getFloat(3);   out.print(IIF(m1)); if(m1<0) m1 = 0;
        out.print("</td><td>");
        float m2 = rs.getFloat(4);   out.print(IIF(m2)); if(m2<0) m2 = 0;
        out.print("</td><td>");
        float m3 = rs.getFloat(5);   out.print(IIF(m3)); if(m3<0) m3 = 0;
        out.print("</td><td>");
        float m4 = rs.getFloat(6);   out.print(IIF(m4)); if(m4<0) m4 = 0;
        out.print("</td><td>");
        float m5 = rs.getFloat(7);   out.print(IIF(m5)); if(m5<0) m5 = 0;
        out.print("</td><td>");
        float m6 = rs.getFloat(8);   out.print(IIF(m6)); if(m6<0) m6 = 0;
        out.print("</td><td>");
        float m7= rs.getFloat(9);    out.print(IIF(m7)); if(m7<0) m7 = 0;
        out.print("</td><td>");
        float m8 = rs.getFloat(10);  out.print(IIF(m8)); if(m8<0) m8 = 0;
        out.print("</td><td>");
        float m9 = rs.getFloat(11);  out.print(IIF(m9)); if(m9<0) m9 = 0;
        out.print("</td><td>");
        float m10 = rs.getFloat(12); out.print(IIF(m10)); if(m10<0) m10 = 0;
        out.print("</td><td>");
        float m11 = rs.getFloat(13); out.print(IIF(m11)); if(m11<0) m11 = 0;
        out.print("</td><td>");
        float m12 = rs.getFloat(14); out.print(IIF(m12)); if(m12<0) m12 = 0;
        out.print("</td><td>");
        float m13 = rs.getFloat(15); out.print(IIF(m13)); if(m13<0) m13 = 0;
        out.print("</td><td>");
        float m14 = rs.getFloat(16); out.print(IIF(m14)); if(m14<0) m14 = 0;
        out.print("</td><td>");
        float score = m1+m2+m3+m4+m5+m6+m7+m8+m9+m10+m11+m12+m13+m14;
        out.print(score);
        out.println("</td><tr>");
        i = i+1;
    }
    rs.close();
    stmt.close();
    
    dao.releaseConnection(con);
  %>
  <%! String IIF(float v){
	   if(v<0.0){
		   return "";
	   }else{
		   return Float.toString(v);
	   }
  }
  %>
  </tbody></table>
  </body>
</html>