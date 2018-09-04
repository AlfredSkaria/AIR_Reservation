package model;

public class BookingStatus {
	private String username;
	private String flightno;
	private float amount;
	private boolean booked;
	
	public BookingStatus(String username, String flightno, float amount, boolean booked) {
		super();
		this.username = username;
		this.flightno = flightno;
		this.amount = amount;
		this.booked = booked;
	}

	@Override
	public String toString() {
		return "BookingStatus [username=" + username + ", flightno=" + flightno + ", amount=" + amount + ", booked="
				+ booked + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFlightno() {
		return flightno;
	}

	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	
	

}
