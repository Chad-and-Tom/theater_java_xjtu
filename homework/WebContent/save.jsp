<%@ page import="java.util.*"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%request.setCharacterEncoding("utf-8");%>
<%@ page import="homework.*" %>
<%
	PersonDao personDao = (PersonDao) application.getAttribute("personDao");
	if (personDao == null) {
	    personDao = new PersonDao();
	    application.setAttribute("personDao", personDao);
	}
	String username = (String) session.getAttribute("username");
	Person per=personDao.getPerson(username);
	personDao.getPerson(username).update(
			(String) request.getParameter("password"),
			(String) request.getParameter("name"),
			(String) request.getParameter("age"),
			(String) request.getParameter("hobby"),
			(String) request.getParameter("detail")
	);
	session.setAttribute("password",request.getParameter("password"));
	session.setAttribute("name",request.getParameter("name"));
	session.setAttribute("age",request.getParameter("age"));
	session.setAttribute("hobby",request.getParameter("hobby"));
	session.setAttribute("detail",request.getParameter("detail"));
	response.sendRedirect("result.jsp");
%>