package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.AdminDetails;
import com.example.demo.Entity.UpdateDetails;
import com.example.demo.Entity.UserDetails;
import com.example.demo.Entity.UserLeaveRequest;

@Service
@Repository
public interface EmployeeService {
	

	void save(UserDetails userDetails);
	
	void save(AdminDetails adminDetails);
	
	Optional<UserDetails> findUserById(int userID);
	
	Optional<AdminDetails> findAdminById(int adminID);
	
	List<UserDetails> getAllUsers();
	
	UserDetails updateEmployee(UserDetails userDetails);
	
	void deleteEmployeeByID(int id);
	
	List<AdminDetails> getAllAdmins();
	
	List<UserLeaveRequest> findUserByLeaveRequest(int userID);
	
	void deleteUserLeaveRequestById(int id);
	
	List<UserLeaveRequest> findAdminByLeaveRequest(int adminID);
	
	Optional<UserLeaveRequest> findLeaveRequestByLeaveID(int leaveID);
	
	UserLeaveRequest updateUserLeaveRequest(UserLeaveRequest userLeaveRequest);
	
	List<UpdateDetails> getallUpdates();
	
	void save(UpdateDetails updateDetails);
	
	void deleteUpdateByID(int id);
	
	Optional<UpdateDetails> findUpdateById(int id);
	
}
