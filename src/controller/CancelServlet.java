package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CancelDatabase;
import dao.DBConnectionManager;

import static utility.Constants.*;
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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String uname = null;
		uname = (String) session.getAttribute("username");
		if(uname!=null)
		{
			String ticketid = request.getParameter(TICKETID);
			session.setAttribute("ticketid", ticketid);
			CancelDatabase cd = new CancelDatabase();
			DBConnectionManager dbManager = (DBConnectionManager) getServletContext().getAttribute(DBMANAGER);
			if(!ticketid.isEmpty())
			{
				
				
				boolean cancelled = cd.cancelTicket(dbManager,ticketid);
				if(cancelled)
				{
					RequestDispatcher rd = request.getRequestDispatcher("cancel.jsp");
					request.setAttribute("cancelled","Your Booking has been cancelled. The amount will be refunded in 24hours.");
					rd.include(request, response);
				}
				else  	//please call administratore
				{
					RequestDispatcher rd = request.getRequestDispatcher("cancel.jsp");
					request.setAttribute("cancelled","please call administrator");
					rd.include(request, response);
				}
			}
			else		//input fields empty
			{
				RequestDispatcher rd = request.getRequestDispatcher("cancel.jsp");
				request.setAttribute("cancelled","input fields are empty");
				rd.include(request, response);
			}
		}
		else		//session invalid
		{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("error","please login again");
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
