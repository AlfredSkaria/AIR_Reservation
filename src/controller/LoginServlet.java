package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBConnectionManager;
import dao.LoginDatabase;
import model.Login;

import static utility.Constants.*;
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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter(USERNAME);
		String password = request.getParameter(PASSWORD);
		HttpSession session = request.getSession();
		
		response.setContentType("text/html");
		if((!username.isEmpty())&&(!password.isEmpty()))
		{
			System.out.println("input fields are not null");
			Login l1 = new Login(username, password);
			LoginDatabase logindb = new LoginDatabase();
			DBConnectionManager dbManager = (DBConnectionManager) getServletContext().getAttribute(DBMANAGER);
			if(logindb.validate(l1,dbManager))
			{
				System.out.println("login successfull");
				session.setAttribute("username", username);
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.include(request, response);
			}
			else
			{
				System.out.println("login unsuccessfull");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				request.setAttribute("loginerror","Login Unsuccessfull");
				rd.include(request, response);
			}
		}
		else
		{
			System.out.println("Input fields are empty");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("error", "Please fill in the details");
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
