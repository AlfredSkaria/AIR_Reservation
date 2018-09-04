package controller;

import static utility.Constants.CITY;
import static utility.Constants.DBMANAGER;
import static utility.Constants.EMAIL;
import static utility.Constants.GENDER;
import static utility.Constants.MOBILE;
import static utility.Constants.NAME;
import static utility.Constants.PASSWORD;
import static utility.Constants.USERNAME;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDatabase;
import dao.DBConnectionManager;
import dao.ProfileDatabase;
import model.Registration;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
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
		String name = request.getParameter(NAME);  
		String mobile = request.getParameter(MOBILE);
		String mail = request.getParameter(EMAIL);
		String password = request.getParameter(PASSWORD);
		String gender = request.getParameter(GENDER);
		String city = request.getParameter(CITY);
		
		String username = (String) session.getAttribute("username");
		
		response.setContentType("text/html");
		if((!name.isEmpty()) || (!mobile.isEmpty()) || (!mail.isEmpty()) || (!password.isEmpty()) || (!gender.isEmpty()) || (!city.isEmpty()))
		{
			System.out.println("inside not null");
			Registration r1 = new Registration(name, mobile, mail, username, password, gender, city);
			ProfileDatabase profile = new ProfileDatabase();
			DBConnectionManager db = (DBConnectionManager) getServletContext().getAttribute(DBMANAGER);
			if(profile.updateOperation(r1,db)) 				//inserting and validating whether an entry is made in customerdatabse
			{
				System.out.println("values inserted is true");
				RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");   	//request dispataching into login.jsp file if insert operation is successfull
				PrintWriter out = response.getWriter();
				request.setAttribute("updated", "successfully updated");
				dispatcher.include(request, response);
			}
			else
			{
				System.out.println("Error inserting values into db");					//Error reported in inserting into database
				RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");		//request dispatching into login.jsp with an error message printing
				PrintWriter out = response.getWriter();
				request.setAttribute("error", "please call administrator");
				dispatcher.include(request, response);
			}
		}
		else	//Please fill any of the following
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");			//request dispatching back to register.jsp, since input fileds ere empty
			request.setAttribute("error", "please fill the datails");
			dispatcher.include(request, response);
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
