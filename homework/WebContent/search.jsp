<%@ page import="java.util.*"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%request.setCharacterEncoding("gb2312");%>
<%@ page import="homework.*" %>
<form action="searching.jsp" method="post">
	 请输入查找用户名：<input type="text" name="searchname" />	<br /><br />
    <input type="submit" value="确定" />
</form>
