package homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		if(session.getAttribute("username")!=null){request.setAttribute("message", "已有账号登录，请注销当前账号或关闭浏览器后重试");
    	request.getRequestDispatcher("message.jsp").forward(request, response);}
		else{PersonDao personDao = (PersonDao) application.getAttribute("personDao");
		if (personDao == null) {
		    personDao = new PersonDao();
		    try {
				personDao.initalize();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    application.setAttribute("personDao", personDao);
		}
		String username=(String) request.getParameter("username");
		String password=(String) request.getParameter("password");
		if(personDao.checkUsername(username))
		{request.setAttribute("message", "账号不存在，请确认");
    	request.getRequestDispatcher("message.jsp").forward(request, response);}
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
			if(personDao.getPerson(username).getTicket()){
				session.setAttribute("ticket", "已订座");
				session.setAttribute("row", personDao.getPerson(username).getRow());
				session.setAttribute("column", personDao.getPerson(username).getColumn());
			}else{
				session.setAttribute("ticket", "未订座");
				session.setAttribute("row", null);
				session.setAttribute("column", null);
			}
			response.sendRedirect("result.jsp");
		}else{
			request.setAttribute("message", "密码不正确，请确认");
	    	request.getRequestDispatcher("message.jsp").forward(request, response);
		};
		}}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
