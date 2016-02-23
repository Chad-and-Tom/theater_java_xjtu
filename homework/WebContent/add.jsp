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
    Person person=new Person(
    		(String) request.getParameter("username"),
    		(String) request.getParameter("password"),
    		(int) personDao.getLength(),
    		(String) request.getParameter("name"),
    		(String) request.getParameter("age"),
    		(String) request.getParameter("hobby"),
    		(String) request.getParameter("detail")
    	);
    if(personDao.checkUsername((String) request.getParameter("username"))){
    	personDao.add(person);
    	response.sendRedirect("test.jsp");
}			
else {out.print("账号已存在，请更换");};
%>
<a href="register.jsp">返回上一页</a>