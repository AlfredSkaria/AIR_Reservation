package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CancelDatabase {
	
	public boolean cancelTicket(DBConnectionManager dbManager,String ticketid1)
	{
		Connection con = dbManager.getConnection();
		try {
			System.out.println("Ticket id:"+ticketid1);
			int ticketid = Integer.parseInt(ticketid1);
			String sql = "select * from passengerlist where ticketid='"+ticketid+"'";
			String sql1 = "delete from passengerlist where ticketid='"+ticketid+"'";
			Statement statement = con.createStatement();
			ResultSet rs = dbManager.queryrun(sql);
			while(rs.next())
			{
				
				statement.execute(sql1);
				
			}
			
			String sql2 = "delete from bookingstatus where ticketid='"+ticketid+"'";
			statement.execute(sql2);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

}
