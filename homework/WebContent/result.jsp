<%@ page import="java.util.*"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%request.setCharacterEncoding("gb2312");%>
<%@ page import="homework.*" %>
<h3>您好：${name }(${username }) [<a href="edit.jsp">修改个人信息</a>] [<a href="logout.jsp">注销</a>]</h3>
<a href="search.jsp">查找</a>