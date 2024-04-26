package com.example.demo.Entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="admin_details")
public class AdminDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1, initialValue = 1)
	private int id;

	private String email;
	private String password;
	private String fullName;
	private String phoneNumber;
	
	public AdminDetails() {
		
	}
	
	public AdminDetails(String email, String password, String fullName, String phoneNumber) {
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
