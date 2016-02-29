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
 * Servlet implementation class CancelServlet
 */
@WebServlet("/CancelServlet")
public class CancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelServlet() {
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
		Ticket ticket = (Ticket) application.getAttribute("ticket");
	    if (ticket == null) {
	    	ticket=new Ticket();
	    	try {
	    		ticket.initalize();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        application.setAttribute("ticket", ticket);
	    }
	    PersonDao personDao = (PersonDao) application.getAttribute("personDao");
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
	    String username = (String) session.getAttribute("username");
	    if(personDao.getPerson(username).getTicket()==false){
	    	request.setAttribute("message", "Äú»¹Î´¶©×ù£¬ÇëÏÈ¶©×ù°É");
	    	request.getRequestDispatcher("message.jsp").forward(request, response);
	    }else{
	    	
	    		try {
					ticket.seats[personDao.getPerson(username).getRow()][personDao.getPerson(username).getColumn()]=false;
					personDao.cancel(username);
					session.setAttribute("ticket", "Î´¶©×ù");
					session.setAttribute("row", null);
					session.setAttribute("column", null);
		    		request.setAttribute("message", "ÍË¶©³É¹¦");
			    	request.getRequestDispatcher("DeleteServlet").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	
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
