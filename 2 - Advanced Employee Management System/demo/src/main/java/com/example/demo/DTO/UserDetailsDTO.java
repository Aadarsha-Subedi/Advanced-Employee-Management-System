package com.example.demo.DTO;

public class UserDetailsDTO {

	private int id;

	private String email;
	private String password;
	private String fullName;
	private String phoneNumber;
	
	public UserDetailsDTO() {
		
	}
	
	public UserDetailsDTO(String email, String password, String fullName, String phoneNumber) {
		super();
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", email=" + email + ", password=" + password + ", fullName=" + fullName
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
}
