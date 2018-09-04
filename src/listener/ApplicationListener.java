package listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dao.DBConnectionManager;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ApplicationListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent servletContextEvent)  { 
    	ServletContext sct = servletContextEvent.getServletContext();
    	DBConnectionManager dbManager = (DBConnectionManager) sct.getAttribute("DBManager");
    	dbManager.closeConnection();
    	System.out.println("Database connection closed for Application.");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent servletContextEvent)  { 
        ServletContext sct = servletContextEvent.getServletContext();
    	Properties prop = new Properties();                                //Creating an instance of properties file in java
		//FileInputStream fileInputSream = new FileInputStream("config.properties");
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties");
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("couldnt load properties file");
			e.printStackTrace();
		}                                         //loading the properties file
		String url = prop.getProperty("dburl");                            // fetching details from the properties file
		String uname = prop.getProperty("dbuser");
		String pass = prop.getProperty("dbpass");
		System.out.println("url: "+url+" username: "+uname+" password: "+pass);
		DBConnectionManager db = new DBConnectionManager(url, uname, pass); 
		sct.setAttribute("DBManager", db);
		System.out.println("Database connection initialized for Application.");
    }
	
}
