<%@ page import="java.util.*"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%request.setCharacterEncoding("gb2312");%>
<%@ page import="homework.*" %>
<%
	String username = (String) session.getAttribute("username");
	session.invalidate();
	PersonDao personDao = (PersonDao) application.getAttribute("personDao");
    if (personDao == null) {
        personDao = new PersonDao();
        application.setAttribute("personDao", personDao);
    }
    personDao.getPerson(username).setOnline(false);
    response.sendRedirect("test.jsp");
%>