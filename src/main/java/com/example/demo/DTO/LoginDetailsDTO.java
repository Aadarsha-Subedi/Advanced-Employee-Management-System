package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LoginDetailsDTO {

	@NotNull
	private Integer userID;
	
	@NotBlank
	private String userPassword;

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "LoginDetailsDTO [userID=" + userID + ", userPassword=" + userPassword + "]";
	}
}
