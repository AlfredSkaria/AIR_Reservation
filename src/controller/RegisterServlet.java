package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDatabase;
import dao.DBConnectionManager;
import model.Registration;

import static utility.Constants.*;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//requesting parameters from the register.jsp
		String name = request.getParameter(NAME);  
		String mobile = request.getParameter(MOBILE);
		String mail = request.getParameter(EMAIL);
		String username = request.getParameter(USERNAME);
		String password = request.getParameter(PASSWORD);
		String gender = request.getParameter(GENDER);
		String city = request.getParameter(CITY);
		
		response.setContentType("text/html");
		System.out.println("input fields fetched");
		if((!name.isEmpty()) && (!mobile.isEmpty()) && (!mail.isEmpty()) && (!username.isEmpty())
				&& (!password.isEmpty()) && (!gender.isEmpty()) && (!city.isEmpty())) //checking whether any of the fileds are empty or not null
		{
			System.out.println("inside not null");
			Registration r1 = new Registration(name, mobile, mail, username, password, gender, city);               //creating an object of model class for registration
			CustomerDatabase customerdb = new CustomerDatabase();              //Creating an object of CustomerDatabase for CRUD operation
			
			DBConnectionManager db = (DBConnectionManager) getServletContext().getAttribute(DBMANAGER);
			
			if(customerdb.insertOperation(r1,db)) 				//inserting and validating whether an entry is made in customerdatabse
			{
				System.out.println("values inserted is true");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");   	//request dispataching into login.jsp file if insert operation is successfull
				PrintWriter out = response.getWriter();
				out.println("<p>Successfully registered, please login to continue.</p>");
				dispatcher.include(request, response);
			}
			else
			{
				System.out.println("Error inserting values into db");					//Error reported in inserting into database
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");		//request dispatching into login.jsp with an error message printing
				PrintWriter out = response.getWriter();
				out.println("<p>Please call administrator</p>");
				dispatcher.include(request, response);
			}
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");			//request dispatching back to register.jsp, since input fileds ere empty
			request.setAttribute("error", "please fill all the datails");
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
