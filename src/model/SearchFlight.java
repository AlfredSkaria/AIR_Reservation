package model;

public class SearchFlight {
	
	private String origin;
	private String destination;
	
	public SearchFlight(String origin, String destination) {
		super();
		this.origin = origin;
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "SearchFlight [origin=" + origin + ", destination=" + destination + "]";
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
	
	

}
