<%@ page language="java" contentType="text/html; charset=UTF-8"
    import = "willow.dao.*" 
    import = "willow.dao.jdbc.*"
    import = "willow.dao.dbcp.*"
    import = "willow.dao.tdcp.*"
    import = "willow.dao.c3p0.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
    <%
//        IDao dao = new JdbcDao();
//        IDao dao = new DbcpDao();
//      IDao dao = new TdcpDao();
       IDao dao = new C3p0Dao();
       dao.openConnection();
       dao.printTest();
    %>
</body>
</html>