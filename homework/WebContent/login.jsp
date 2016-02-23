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
	String username=(String) request.getParameter("username");
	String password=(String) request.getParameter("password");
	if(personDao.checkUsername(username))
	{out.print("账号不存在，请注册");}
	else{ if(personDao.checkPassword(username,password)){
		personDao.getPerson(username).setOnline(true);
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		String name=personDao.getPerson(username).getName();
		session.setAttribute("name", name);
		String age=personDao.getPerson(username).getAge();
		session.setAttribute("age", age);
		String hobby=personDao.getPerson(username).getHobby();
		session.setAttribute("hobby", hobby);
		String detail=personDao.getPerson(username).getDetail();
		session.setAttribute("detail", detail);
		response.sendRedirect("result.jsp");
	}else{
		out.print("密码不正确，请确认");
	};
	}
%>
<a href="test.jsp">返回上一页</a>