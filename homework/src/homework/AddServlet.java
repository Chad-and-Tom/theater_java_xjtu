package homework;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("text/html; charset=utf-8");
		ServletContext application = request.getServletContext();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if(((String)request.getParameter("username")).equals("")||((String)request.getParameter("password")).equals("")){
			request.setAttribute("message", "账号或密码均不能为空，请确认");
	    	request.getRequestDispatcher("message.jsp").forward(request, response);
		}
		else{PersonDao personDao = (PersonDao) application.getAttribute("personDao");
	    if (personDao == null) {
	    	personDao=new PersonDao();
	    	try {
				personDao.initalize();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	 
				try {
					personDao.add(person);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	
	    	request.setAttribute("message", "注册成功，返回上一页");
	    	request.getRequestDispatcher("message.jsp").forward(request, response);
	}			
	else {request.setAttribute("message", "账号已存在，请确认");
	request.getRequestDispatcher("message.jsp").forward(request, response);};}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
