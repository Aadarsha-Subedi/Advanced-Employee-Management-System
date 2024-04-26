package com.example.demo.DTO;

import java.util.Date;

public class UpdateDetailsDTO {

	private int id;
	String description;
	Date uploadDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	@Override
	public String toString() {
		return "UpdateDetails [id=" + id + ", description=" + description + ", uploadDate=" + uploadDate + "]";
	}
	
}
