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
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
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
		String username = (String) session.getAttribute("username");
		personDao.getPerson(username).update(
				(String) request.getParameter("password"),
				(String) request.getParameter("name"),
				(String) request.getParameter("age"),
				(String) request.getParameter("hobby"),
				(String) request.getParameter("detail")
		);
		try {
			personDao.update(personDao.getPerson(username));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("password",request.getParameter("password"));
		session.setAttribute("name",request.getParameter("name"));
		session.setAttribute("age",request.getParameter("age"));
		session.setAttribute("hobby",request.getParameter("hobby"));
		session.setAttribute("detail",request.getParameter("detail"));
		response.sendRedirect("result.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
