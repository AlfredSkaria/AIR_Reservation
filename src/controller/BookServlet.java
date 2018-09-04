package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookingDatabase;
import dao.DBConnectionManager;
import model.BookFlight;
import model.BookingStatus;
import model.PassengerList;

import static utility.Constants.*;
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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String flightno = request.getParameter(FLIGHTNO);
		String passengerno = request.getParameter(PASSENGERNO);
		int count = Integer.parseInt(passengerno);
		int i=0;
		String passengername[] = null;
		String age[] = null;
		boolean booked = false;
		System.out.println("flight no:"+flightno);
		System.out.println("no.of passenger: "+passengerno);
		HttpSession session = request.getSession();
		session.setAttribute("flightno",flightno);
		String uname = null;
		uname = (String) session.getAttribute("username");
		System.out.println("username: " + uname);
		if(uname!=null)
		{
			System.out.println("session status: "+ session.isNew() + " session id: "+session.getId());
			if((!flightno.isEmpty()) && (!passengerno.isEmpty()))
			{
				BookFlight b1 = new BookFlight(flightno, passengerno);
				BookingDatabase bookdb = new BookingDatabase();
				DBConnectionManager dbManager = (DBConnectionManager) getServletContext().getAttribute(DBMANAGER);
				float fare = bookdb.calculateFare(b1,dbManager);
				booked = false;
				RequestDispatcher rd = request.getRequestDispatcher("booking.jsp");
				PrintWriter out = response.getWriter();
				out.println("<div><nav >"
						+ "<div class='toggle'><i class='fas fa-bars menu'></i></div>"
						+ "<ul >"
						+ "<li><a href='search.jsp' >Search Flights</a></li>"
						+ "<li><a href='Book'>Book Flights</a></li>"
						+ "<li><a href='cancel.jsp'>Cancel Ticket</a></li>"
						+ "<li><a href='profile.jsp'>Hi "+session.getAttribute("username")+" !!</li>"
						+ "<li><a href='logout.jsp'>Logout</a></li></ul>"
						+ "</nav></div>");
						out.println("<br><br><div class='col-sm-3 col-md-3' style='margin-left:2%;'>"
						+ "<form action='ConfirmBooking' method='post'>"
						+ "<div class='form-group'>"
						+ "<label for='passenger names'>Enter the name and age of passengers:</label>");
				for(i=0;i<count;i++)
				{
					String nameOfPassenger = "passengername"+i;
					String ageOfPassenger = "age"+i;
					out.println(" <input type='text' class='form-control' placeholder='Enter name of passenger' name='"+nameOfPassenger+"'>"
							+ "<input type='text' class='form-control' placeholder='Enter age of passenger' name='"+ageOfPassenger+"'><br>");
				}
				out.println("</div>"
							+ "<br><h2>Total Fare:"+fare+"</h2>"
							+ "<input type='submit' class='btn btn-primary' value='Pay Now'>"
							+ "</form>"
							+ "</div><br>");
				session.setAttribute("passengerno", passengerno);
				session.setAttribute("fare", fare);
				rd.include(request, response);
			}
			else		//input fields are empty
			{
				System.out.println("input fields are empty");
				RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
				request.setAttribute("error","please fill in the details");
				rd.include(request, response);
			}
			
		}
		else		//session invalid
		{
			System.out.println("session is invlaid");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("error", "please login again");
			rd.include(request, response);
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
