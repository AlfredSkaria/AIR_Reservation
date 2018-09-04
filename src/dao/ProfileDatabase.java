package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Registration;

public class ProfileDatabase {
	public boolean updateOperation(Registration r1,DBConnectionManager dbManager)
	{
		String sql="update customer set name='"+r1.getName()+"',mobile='"+r1.getMobile()+"',email='"+r1.getEmail()+"',"
				+ "password='"+r1.getPassword()+"',gender='"+r1.getGender()+"',city='"+r1.getCity()+"' where username='"+r1.getUsername()+"'";
		Connection con = dbManager.getConnection();
		try {
			Statement statement = con.createStatement();
			statement.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
		
	}
	
}
