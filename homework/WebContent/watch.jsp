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
	Person per=new Person(personDao.getPerson(searchname));
	pageContext.setAttribute("searchname", searchname);
	pageContext.setAttribute("name", per.getName());
	pageContext.setAttribute("age", per.getAge());
	pageContext.setAttribute("hobby", per.getHobby());
	pageContext.setAttribute("detail", per.getDetail());
	pageContext.setAttribute("checkonline",personDao.getPerson(searchname).checkOnline());
%>
<h3>用户名：${searchname}</h3>
<h3>姓名：${name}</h3>
<h3>年龄：${age}</h3>
<h3>爱好：${hobby}</h3>
<h3>详情：${detail}</h3>
<h3>状态：${checkonline}</h3>
<a href="search.jsp">返回上一页</a>