package model;

public class BookFlight {
	
	private String flightno;
	private String passengerno;
	
	public BookFlight(String flightno, String passengerno) {
		super();
		this.flightno = flightno;
		this.passengerno = passengerno;
	}

	@Override
	public String toString() {
		return "BookFlight [flightno=" + flightno + ", passengerno=" + passengerno + "]";
	}

	public String getFlightno() {
		return flightno;
	}

	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}

	public String getPassengerno() {
		return passengerno;
	}

	public void setPassengerno(String passengerno) {
		this.passengerno = passengerno;
	}
	
	
	

}
