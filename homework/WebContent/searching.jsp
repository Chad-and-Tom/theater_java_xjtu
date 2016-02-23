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
	String searchname=(String) request.getParameter("searchname");
	if(personDao.checkUsername(searchname)){
		out.print("用户名不存在，请确认");
	}else{
		 request.getRequestDispatcher("watch.jsp").forward(request, response);
	}
%>
<a href="search.jsp">返回上一页</a>