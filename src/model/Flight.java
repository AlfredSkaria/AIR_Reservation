package model;

import java.sql.Date;
import java.sql.Time;

public class Flight {
	
	private String flightno;
	private String airlineName;
	private Date departureDate;
	private Time departureTime;
	private Date arrivalDate;
	private Time arrivalTime;
	private String origin;
	private String destination;
	private String fare;
	
	public Flight(String flightno, String airlineName, Date departureDate, Time departureTime, Date arrivalDate,
			Time arrivalTime, String origin, String destination, String fare) {
		super();
		this.flightno = flightno;
		this.airlineName = airlineName;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.origin = origin;
		this.destination = destination;
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "Flight [flightno=" + flightno + ", airlineName=" + airlineName + ", departureDate=" + departureDate
				+ ", departureTime=" + departureTime + ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime
				+ ", origin=" + origin + ", destination=" + destination + ", fare=" + fare + "]";
	}

	public String getFlightno() {
		return flightno;
	}

	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}
	
	
	

}
