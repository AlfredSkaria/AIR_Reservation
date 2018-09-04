package model;

public class Registration {
	
	private String name;
	private String mobile;
	private String email;
	private String username;
	private String password;
	private String gender;
	private String city;
	
	public Registration(String name, String mobile, String email, String username, String password, String gender,
			String city) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Registration [name=" + name + ", mobile=" + mobile + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", gender=" + gender + ", city=" + city + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	

}
