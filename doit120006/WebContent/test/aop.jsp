<%@ page language="java" contentType="text/html; charset=UTF-8"
    import = "willow.aop.*"
    import = "willow.*"
    import = "org.springframework.beans.factory.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
    <%
       HttpSession sss = request.getSession();
       BaseActionSupport bas = new BaseActionSupport();
       BeanFactory bf = (BeanFactory)bas.getBeanFactory(sss);
       IStudent person = (IStudent)bf.getBean("student");
       person.addStudent("dragon");
       person.addStudent("not dragon");
    %>
</body>
</html>