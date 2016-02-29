package homework;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchingServlet
 */
@WebServlet("/SearchingServlet")
public class SearchingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		ServletContext application = request.getServletContext();
		PersonDao personDao = (PersonDao) application.getAttribute("personDao");
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
		String searchname=(String) request.getParameter("searchname");
		if(personDao.checkUsername(searchname)){
			request.setAttribute("message", "用户名不存在，请确认");
	    	request.getRequestDispatcher("message.jsp").forward(request, response);
		}else{
			Person per=new Person(personDao.getPerson(searchname));
			request.setAttribute("searchname", searchname);
			request.setAttribute("name", per.getName());
			request.setAttribute("age", per.getAge());
			request.setAttribute("hobby", per.getHobby());
			request.setAttribute("detail", per.getDetail());
			request.setAttribute("checkonline",personDao.getPerson(searchname).checkOnline());
			request.getRequestDispatcher("watch.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
