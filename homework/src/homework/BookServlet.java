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
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
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
		int row=Integer.parseInt((String)request.getParameter("row"));
		int column=Integer.parseInt((String)request.getParameter("column"));
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
	    if(personDao.getPerson(username).getTicket()){
	    	request.setAttribute("message", "您已经订座了，不能重复订座，请退订后重试");
	    	request.getRequestDispatcher("message.jsp").forward(request, response);
	    }else{
	    	if(ticket.seats[row][column]){
	    		request.setAttribute("message", "该座已被预订了，请重新选择");
		    	request.getRequestDispatcher("message.jsp").forward(request, response);
	    	}else{
	    		try {
					personDao.book(username, row, column);
					ticket.seats[row][column]=true;
					session.setAttribute("ticket", "已订座");
					session.setAttribute("row", personDao.getPerson(username).getRow());
					session.setAttribute("column", personDao.getPerson(username).getColumn());
		    		
			    	request.getRequestDispatcher("MovieServlet").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
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
