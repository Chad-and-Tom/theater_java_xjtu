<%@ page import="java.util.*"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%request.setCharacterEncoding("gb2312");%>
<%@ page import="homework.*" %>
<%	
	PersonDao personDao = (PersonDao) application.getAttribute("personDao");
	if (personDao == null) {
	    personDao = new PersonDao();
	    application.setAttribute("personDao", personDao);
	}
	String username = (String) session.getAttribute("username");
	String password = (String) session.getAttribute("password]");
	String name = (String) session.getAttribute("name");
	String age = (String) session.getAttribute("age");
	String hobby = (String) session.getAttribute("hobby");
	String detail = (String) session.getAttribute("detail");
%>>
<form action="save.jsp" method="post">
	账号：${username}	<br /><br />
	密码：<input type="text" name="password" value="${password}" />	<br /><br />
	姓名：<input type="text" name="name" value="${ name}" />		<br /><br />
	年龄：<input type="text" name="age" value="${ age}" />		<br /><br />
	爱好：<input type="text" name="hobby" value="${ hobby}" />	<br /><br />
	详情：<input type="text" name="detail" value="${ detail}" />	<br /><br />
    <input type="submit" value="保存" />
</form>
<a href="result.jsp">取消并返回</a>