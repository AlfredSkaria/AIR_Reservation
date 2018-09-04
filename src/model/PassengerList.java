package model;

import java.util.Arrays;

public class PassengerList {

	private String username;
	private String flightno;
	private String passenger[];
	private String age[];
	private String passengerno;
	
	public PassengerList(String username, String flightno, String[] passenger, String[] age, String passengerno) {
		super();
		this.username = username;
		this.flightno = flightno;
		this.passenger = passenger;
		this.age = age;
		this.passengerno = passengerno;
	}

	@Override
	public String toString() {
		return "PassengerList [username=" + username + ", flightno=" + flightno + ", passenger="
				+ Arrays.toString(passenger) + ", age=" + Arrays.toString(age) + ", passengerno=" + passengerno + "]";
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

	public String[] getPassenger() {
		return passenger;
	}

	public void setPassenger(String[] passenger) {
		this.passenger = passenger;
	}

	public String[] getAge() {
		return age;
	}

	public void setAge(String[] age) {
		this.age = age;
	}

	public String getPassengerno() {
		return passengerno;
	}

	public void setPassengerno(String passengerno) {
		this.passengerno = passengerno;
	}

	
	
}
