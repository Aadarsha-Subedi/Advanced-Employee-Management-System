package com.example.demo.Entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.Date;

@Component
@Entity
@Table(name="user_leave_requests")
public class UserLeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leave_sequence")
    @SequenceGenerator(name = "leave_sequence", sequenceName = "leave_sequence", allocationSize = 1, initialValue = 10000)
    private int id;

    @ManyToOne
    private UserDetails employee;

    @ManyToOne
    private AdminDetails admin;

    private String description;
    private Date startDate;
    private Date endDate;

    private boolean approved;
    private boolean rejected;

    public UserLeaveRequest() {
    }

    public UserLeaveRequest(UserDetails employee, String description, Date startDate, Date endDate) {
        this.employee = employee;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDetails getEmployee() {
        return employee;
    }

    public void setEmployee(UserDetails employee) {
        this.employee = employee;
    }

    public AdminDetails getAdmin() {
        return admin;
    }

    public void setAdmin(AdminDetails admin) {
        this.admin = admin;
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
        return "LeaveRequest{" +
                "id=" + id +
                ", employee=" + employee +
                ", admin=" + admin +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", approved=" + approved +
                ", rejected=" + rejected +
                '}';
    }
}
