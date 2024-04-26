package com.example.demo.Entity;

import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "update_details")
public class UpdateDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "update_sequence")
    @SequenceGenerator(name = "update_sequence", sequenceName = "update_sequence", allocationSize = 1, initialValue = 50000)
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
