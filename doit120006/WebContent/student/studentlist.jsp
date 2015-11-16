<%@ page language="java" contentType="text/html; charset=UTF-8"
    import = "java.util.*"
    import = "willow.business.student.*"
    import = "willow.entity.*"
    pageEncoding="UTF-8"
%>
<%
    String path = request.getContextPath(); //doit
    String basePath = request.getScheme()+"://"+request.getServerName();
    basePath = basePath + ":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Filename: studentlist.jsp -->
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生信息列表</title>
    <link href="lib/willow.css" rel="stylesheet" type="text/css">
    <link href="lib/table.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="lib/page.js"></script>
    <script type="text/javascript" src="student/lib/studentlist.js"></script>
  </head>
  <%
    //是服务器端接收客户端提交信息的实体类,也是返回信息的实体类
    StudentListForm pf = (StudentListForm)request.getAttribute("slf");
    List<Student> list = (List<Student>)request.getAttribute("list");
  %>
  <body  bottommargin="0" topmargin="0">

  <form name="frm" method="post" action="student/studentlist.action" onsubmit="return doCheck();">
    <!-- 页面提交给服务器的信息,在服务器端需要有接收 -->
    <input type="hidden" name="pagePoint" value="<%=pf.getPagePoint() %>">
    <input type="hidden" name="pageCount" value="<%=pf.getPageCount() %>">
    <input type="hidden" name="pageSizes" value="<%=pf.getPageSizes() %>">
    <input type="hidden" name="func" value="<%=pf.getFunc() %>">
    <input type="hidden" name="cond" value="<%=pf.getCond() %>">
    
    <table style="border:0px;padding:2px;width:100%;height:100%;margin:0;">
    <tr><td valign="middle" align="center">

  <table border="0" width="760"><caption>注册学生信息类表</caption>
    <thead>
      <tr bgcolor="#e0e0e0"><td colspan="8"></td></tr><tr>
        <td colspan="8" align="left">
          <input type="radio" name="field" value="id">按学号查询 
          <input type="radio" name="field" value="name">按姓名查询 
          <input type="text" name="criteria" value="" style="width:180px">
          <input type="submit" value="查询">
        </td>
      </tr><tr bgcolor="#e0e0e0">
        <th width="100px" align="left">学号</th>
        <th width="100px" align="left">姓名</th>
        <th width="60px"  align="left">性别</th>
        <th width="100px" align="left">年龄</th>
        <th width="100px" align="left">年级</th>
        <th width="100px" align="left">班级</th>
        <th width="100px" align="left">院系</th>
        <th width="100px" align="left">专业</th>
      </tr></thead>
    <tbody>
    <%
      for(int i=0;i<list.size();i++){
          Student student = list.get(i);
    %>
    <tr id="tr_<%=student.getId()%>" bgcolor="<% if(i%2==1) out.print("#f0f0f0"); %>"
        onclick="selectnode('<%=student.getId()%>');"
        onmouseover="cc=this.bgColor; this.bgColor='LemonChiffon'"  
        onmouseout ="this.bgColor=cc; " 
    >
      <td align="left"><%=student.getId()%></td>
      <td align="left"><%=student.getName() %></td>
      <td align="left"><%//=student.getBirthday() %></td>
      <td align="left"><%=student.getBirthday() %></td>
    <td align="left"><%//=f.getDescription() %></td>
    <td align="left"><%//=f.getDescription() %></td>
    <td align="left"><%//=f.getDescription() %></td>
    <td align="left"><%//=f.getDescription() %></td>
    </tr>
  <%  } // %>
  
  </tbody><tfoot>
    <tr bgcolor="#e0e0e0">
        <td colspan="2" align="left">
        每页<%=pf.getPageSizes()%>条记录/共<%=pf.getPageCount()+1%>页/当前第<%=pf.getPagePoint()+1%>页
        </td><td colspan="4" align="left">
          <input type="button" name="firt" value="第一页" onclick="getFirst()">
          <input type="button" name="prev" value="前一页" onclick="getPrevious()">
          <input type="button" name="next" value="下一页" onclick="getNext()">
          <input type="button" name="last" value="末一页" onclick="getLast()">
        </td><td colspan="2" align="right">
      <input type="button" name="firt" value="增加" onclick="doCheck()">
      <input type="button" name="prev" value="删除" onclick="doCheck()">
      <input type="button" name="next" value="修改" onclick="doCheck()">
      <input type="button" name="last" value="返回" onclick="doCheck()">
        </td></tr>
  </tfoot></table>
  
  </td></tr></table></form>  
  
  </body>
</html>