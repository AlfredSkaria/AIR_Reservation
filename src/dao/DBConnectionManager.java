package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionManager {
	private Connection con;					//creating a connection variable
	
	public DBConnectionManager(String url,String username,String password) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");    //load driver
			System.out.println("Driver Loaded");
			this.con = DriverManager.getConnection(url, username, password);       //making connection to the specified url with username and password
			System.out.println("connected");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public Connection getConnection()
	{
		return this.con;			//returning the connection object
	}
	
	public ResultSet queryrun(String sql) throws SQLException				// function for executing sql queries
	{
		Statement statement = con.createStatement();				//creating a statement
		return statement.executeQuery(sql);							//returning the result from running the sql query
	}


	public void closeConnection() {
		try {
			this.con.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}

}
