package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.tools.internal.ws.processor.model.Request;

import model.Login;

public class LoginDatabase {
	
	public LoginDatabase() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean validate(Login login, DBConnectionManager dbManager)
	{
		
		Connection con = dbManager.getConnection();
		try {
			String username = login.getUsername();
			String password = login.getPassword();
			String uname = null;
			Statement statement = con.createStatement();
			String sql="select username from customer where username='"+username+"' and password='"+password+"'";
			ResultSet rs = dbManager.queryrun(sql);
			while(rs.next())
			{
				uname=rs.getString("username");
			}
			if(uname!=null)
			{
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
