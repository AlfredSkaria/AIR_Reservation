package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import model.BookFlight;
import model.BookingStatus;
import model.PassengerList;

public class BookingDatabase {

	
	public float calculateFare(BookFlight b1, DBConnectionManager dbManager)
	{
		String flightno;
		String passengerno;
		String fare = null;
		int noOfPassenger;
		int price;
		int totalamount;
		Connection con = dbManager.getConnection();
		try {
			flightno = b1.getFlightno();
			passengerno = b1.getPassengerno();
			noOfPassenger = Integer.parseInt(passengerno);
			String sql = "select fare from flight where flightno='"+flightno+"'";
			ResultSet rs = dbManager.queryrun(sql);
			while(rs.next())
			{
				fare = rs.getString("fare");
			}
			price = Integer.parseInt(fare);
			System.out.println("Fare for flightno:"+flightno+" is:"+price);
			
		totalamount = price * noOfPassenger;	
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return totalamount;
		
	}
	
	public boolean addPassenger(PassengerList p1,DBConnectionManager dbManager,BookingStatus bs,String ticketid)
	{
		Connection con = dbManager.getConnection();
		try {
			String username = p1.getUsername();
			String flightno = p1.getFlightno();
			String passengername[] = new String[10];
			String age[] = new String[10];
			int count = Integer.parseInt(p1.getPassengerno());
			int i=0;
			String[] pnames = p1.getPassenger();
			String[] ages = p1.getAge();
			for (i=0;i<count;i++)
			{
				passengername[i] = pnames[i];
				age[i] = ages[i];
				System.out.println("pname : "+passengername[i]);
				System.out.println("age : "+age[i]);
			}
			
			
			String sql,sql1;
			Statement statement = con.createStatement();
			for(i=0;i<count;i++){
				sql="insert into passengerlist values('"+username+"','"+flightno+"','"+passengername[i]+"','"+age[i]+"','"+ticketid+"')";
				//ResultSet rs = dbManager.queryrun(sql);
				statement.executeUpdate(sql);
			}
			
			sql1="insert into bookingstatus values('"+username+"','"+flightno+"','"+bs.getAmount()+"','"+bs.isBooked()+"','"+ticketid+"','"+count+"')";
			//ResultSet rs = dbManager.queryrun(sql1);
			statement.executeUpdate(sql1);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
}
