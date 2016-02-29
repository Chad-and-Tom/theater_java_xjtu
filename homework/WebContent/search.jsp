<%@ page import="java.util.*"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%@ page import="homework.*" %>
<form action="SearchingServlet" method="post">
	 请输入查找用户名：<input type="text" name="searchname" />	<br /><br />
    <input type="submit" value="确定" />
</form>
<a href="javascript:history.back()">返回上一页</a>
