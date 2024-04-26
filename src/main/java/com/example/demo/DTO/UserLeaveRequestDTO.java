package com.example.demo.DTO;

import java.util.Date;

public class UserLeaveRequestDTO {
	
	private int id;
	private int userID;
	private int adminID;
	private String description;
    private Date startDate;
    private Date endDate;

    private boolean approved;
    private boolean rejected;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public boolean isRejected() {
		return rejected;
	}
	public void setRejected(boolean rejected) {
		this.rejected = rejected;
	}
	@Override
	public String toString() {
		return "LeaveRequestDTO [id=" + id + ", userID=" + userID + ", adminID=" + adminID + ", description="
				+ description + ", startDate=" + startDate + ", endDate=" + endDate + ", approved=" + approved
				+ ", rejected=" + rejected + "]";
	}
}
