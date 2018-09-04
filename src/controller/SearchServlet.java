package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dao.DBConnectionManager;
import dao.SearchDatabase;
import model.Flight;
import model.SearchFlight;

import static utility.Constants.*;
/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String origin = request.getParameter(ORIGIN);
		String destination = request.getParameter(DESTINATION);
		ArrayList<Flight> flightlist = new ArrayList<>();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		String uname = null;
		uname = (String) session.getAttribute("username");
		System.out.println("username: " + uname);
		if(uname!=null)
		{
			System.out.println("session status: "+ session.isNew() + " session id: "+session.getId());
			if((!origin.isEmpty()) && (!destination.isEmpty()))
			{
				SearchFlight searchFlight = new SearchFlight(origin, destination);
				SearchDatabase searchdb = new SearchDatabase();
				DBConnectionManager dbManager = (DBConnectionManager) getServletContext().getAttribute(DBMANAGER);
				int count = searchdb.numberOfFlights(searchFlight,dbManager);
				System.out.println("No.of Flights: "+count);
				flightlist = searchdb.search(searchFlight,dbManager);
						if(count!=0)
						{
							System.out.println("Flight list obtained");
							RequestDispatcher rd = request.getRequestDispatcher("searchresults.jsp");
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
							/*out.println("<h4 style='margin-left:3%>Flight List:</h4>");*/
							out.println("<br><div><div class='container'><table class = 'table table-bordered table-hover'><thead><tr><th>Flight No</th><th>Airline Name</th>"
									+ "<th>Departure date and time</th><th>Arrival date and time</th><th>Origin</th><th>Destination</th><th>Fare</th></tr></thead></table></div></div>");
							for(Flight f:flightlist)
							{
								
								out.println("<div class = 'container'><table class = 'table table-bordered table-hover'><tbody><tr><td>"+f.getFlightno()+"</td><td>"+f.getAirlineName()+"</td><td>"+f.getDepartureDate()+"  "+f.getDepartureTime()+"</td>"
										+ "<td>"+f.getArrivalDate()+"  "+f.getArrivalTime()+"</td><td>"+f.getOrigin()+"</td><td>"+f.getDestination()+"</td>"
										+ "<td>"+f.getFare()+"</td></tr></tbody></table></div>");
								
							}
							out.println("<div class='col-sm-6 col-md-6' style='margin-left:2%;'>"
									+ "<form action='BookServlet' method='post'>"
									+ "<div class='form-group'>"
									+ "<label for='Flight No:'>Flight No:</label>"
									+ " <input type='text' class='form-control' placeholder='Enter flight no:' name='flightno'>"
									+ "</div>"
									+ "<div class='form-group'>"
									+ "<label for='No.oF Passengers:'>No.Of Passengers</label>"
									+ " <input type='text' class='form-control' placeholder='No.of Passengers' name='passengerno'>"
									+ "</div>"
									+ "<input type='submit' class='btn btn-primary' value='Book Now'>"
									+ "</form></div><br>");
							
							
							rd.include(request, response);
						}
						else	//cannot find flights
						{
							System.out.println("Cannot find any flights");
							RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
							request.setAttribute("noflights", "Cannot find any flights");
							rd.include(request, response);
						}
				
			}
			else 		// input fields are empty
			{
				System.out.println("input fields are empty");
				RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
				request.setAttribute("error","please fill in the details");
				rd.include(request, response);
			}
		}
		else  		//session invalid
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
