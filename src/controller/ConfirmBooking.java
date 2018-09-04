package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookingDatabase;
import dao.DBConnectionManager;
import model.BookingStatus;
import model.PassengerList;

import static utility.Constants.*;
/**
 * Servlet implementation class ConfirmBooking
 */
@WebServlet("/ConfirmBooking")
public class ConfirmBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//String flightno = request.getParameter(FLIGHTNO);
		//String passengerno = request.getParameter(PASSENGERNO);
		HttpSession session = request.getSession();
		String passengerno = (String) session.getAttribute("passengerno");
		int count = Integer.parseInt(passengerno);
		System.out.println("no.of passengers"+count);
		String flightno = (String) session.getAttribute("flightno");
		String passengername[] = new String[10] ;
		String age[] = new String[10];
		boolean booked = false;
		
		//int count = Integer.parseInt(passengerno);
		String uname = null;
		
		uname = (String) session.getAttribute("username");
		System.out.println("username: " + uname);
		if(uname!=null)
		{
					Random rand = new Random();
					int id = rand.nextInt(9999)+1;
					String ticketid = Integer.toString(id);
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
				for(int i=0;i<count;i++)
				{
					System.out.println("hi");
					passengername[i] = request.getParameter(PASSENGERNAME+i);
					age[i] = request.getParameter(AGE+i);
					System.out.println("passenger name"+passengername[i]);
					System.out.println("age"+age[i]);
				}
				
				
				booked = true;
				float fare = (float) session.getAttribute("fare");
				PassengerList p1 = new PassengerList(uname, flightno, passengername, age,passengerno);
				BookingStatus status = new BookingStatus(uname, flightno, fare, booked);
				BookingDatabase bookdb = new BookingDatabase();
				DBConnectionManager dbManager = (DBConnectionManager) getServletContext().getAttribute(DBMANAGER);
				boolean addedPassenger = bookdb.addPassenger(p1,dbManager,status,ticketid);
				RequestDispatcher rd = request.getRequestDispatcher("bookedstatus.jsp");
				//request.setAttribute("status", addedPassenger);
				out.println("<h3>Your Ticket has been booked </h3>");
				out.println("<h4>Ticket Id:"+ticketid+"</h4>");
				out.println("<h4>No.Of Passengers: "+count+"</h4>");
				out.println("<h4>Amount paid: "+session.getAttribute("fare")+"</h4>");
				rd.include(request, response);
				
		}
		else 		//session invalid
		{
			System.out.println("Session not valid");
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
