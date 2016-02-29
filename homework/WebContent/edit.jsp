<%@ page import="java.util.*"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%@ page import="homework.*" %>

<form action="SaveServlet" method="post">
	账号：${username}	<br /><br />
	密码：<input type="text" name="password" value="${password}" />	<br /><br />
	姓名：<input type="text" name="name" value="${ name}" />		<br /><br />
	年龄：<input type="text" name="age" value="${ age}" />		<br /><br />
	爱好：<input type="text" name="hobby" value="${ hobby}" />	<br /><br />
	详情：<input type="text" name="detail" value="${ detail}" />	<br /><br />
    <input type="submit" value="保存" />
</form>
<a href="javascript:history.back()">取消并返回</a>