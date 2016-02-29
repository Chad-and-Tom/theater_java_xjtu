<%@ page import="java.util.*"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%@ page import="homework.*" %>
<h3>用户名：${searchname}</h3>
<h3>姓名：${name}</h3>
<h3>年龄：${age}</h3>
<h3>爱好：${hobby}</h3>
<h3>详情：${detail}</h3>
<h3>状态：${checkonline}</h3>
<a href="javascript:history.back()">返回上一页</a>