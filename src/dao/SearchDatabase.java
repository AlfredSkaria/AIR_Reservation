package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import model.Flight;
import model.SearchFlight;

public class SearchDatabase {
	
	public ArrayList<Flight> search(SearchFlight searchFlight, DBConnectionManager dbManager)
	{
			String flightNo = null;
			String airlineName = null;
			Date departureDate = null;
			Time departureTime = null;
			Date arrivalDate = null;
			Time arrivalTime = null;
			String origin = null;
			String destination = null;
			String fare= null;
			
			ArrayList<Flight> flightlist = new ArrayList<>();
			
		Connection con = dbManager.getConnection();
		try {
			
			String org = searchFlight.getOrigin();
			String dest =  searchFlight.getDestination();
			//Statement statement = con.createStatement();
			String sql = "select * from flight where origin='"+org+"' and destination='"+dest+"'";
			ResultSet rs = dbManager.queryrun(sql);
			while(rs.next())
			{
				flightNo = rs.getString(1);
				airlineName = rs.getString(2);
				departureDate = rs.getDate(3);
				departureTime = rs.getTime(4);
				arrivalDate = rs.getDate(5);
				arrivalTime = rs.getTime(6);
				origin = rs.getString(7);
				destination = rs.getString(8);
				fare = rs.getString(9);
				Flight f1 = new Flight(flightNo, airlineName, departureDate, departureTime, arrivalDate, arrivalTime, origin, destination, fare);
				
				flightlist.add(f1);
			}
			
			
			
		} catch (SQLException  e) {
			e.printStackTrace();
			return null;
		}
		return flightlist;
		
	}
	
	
	public int numberOfFlights(SearchFlight search, DBConnectionManager dbManager)
	{
		Connection con = dbManager.getConnection();
		int count = 0;
		try {
			String org = search.getOrigin();
			String dest =  search.getDestination();
			Statement statement = con.createStatement();
			String sql = "select count(flightno) from flight where origin='"+org+"' and destination='"+dest+"'";
			ResultSet rs = dbManager.queryrun(sql);
			
			while(rs.next())
			{
				count = rs.getInt(1);
			}
			System.out.println("no.of flights:"+count);
		} catch (SQLException  e) {
			e.printStackTrace();
			return 0;
		}
		return count;
		
	}

}
