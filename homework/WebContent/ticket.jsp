<%@ page import="java.util.*"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%@ page import="homework.*" %>
<a >状态：${ticket}</a><br /><br />
<a >排号：${row}</a><br /><br />
<a >座号：${column}</a><br /><br />
<form action="Ticket1" method="post">
    <input type="submit" value="订座" />
    </form>
    [<a href="CancelServlet">我要退订</a>] 
<a href="javascript:history.back()">返回上一页</a>