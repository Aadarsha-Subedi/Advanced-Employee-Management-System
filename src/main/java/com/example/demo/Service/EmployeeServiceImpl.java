package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.AdminDetails;
import com.example.demo.Entity.UpdateDetails;
import com.example.demo.Entity.UserDetails;
import com.example.demo.Entity.UserLeaveRequest;
import com.example.demo.Repository.AdminRepository;
import com.example.demo.Repository.EmployeeLeaveRepository;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Repository.UpdateDetailsRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private EmployeeLeaveRepository employeeLeaveRepository;
	
	@Autowired
	UpdateDetailsRepository updateDetailsRepository;
	
	public void save(UserDetails userDetails) {
		employeeRepository.save(userDetails);
	}


	@Override
	public void save(AdminDetails adminDetails) {
		adminRepository.save(adminDetails);
	}
	
	@Override
	public Optional<UserDetails> findUserById(int userID) {
		return employeeRepository.findById(userID);
	}


	@Override
	public Optional<AdminDetails> findAdminById(int adminID) {
		return adminRepository.findById(adminID);
	}


	@Override
	public List<UserDetails> getAllUsers() {
		return employeeRepository.findAll();
	}


	@Override
	public UserDetails updateEmployee(UserDetails userDetails) {
		return employeeRepository.save(userDetails);
	}
	


	@Override
	public void deleteEmployeeByID(int id) {
		employeeRepository.deleteById(id);
	}


	@Override
	public List<AdminDetails> getAllAdmins() {
		return adminRepository.findAll();
	}


	@Override
	public List<UserLeaveRequest> findUserByLeaveRequest(int userID) {
		return employeeLeaveRepository.findByEmployee_Id(userID);
	}


	@Override
	public void deleteUserLeaveRequestById(int id) {
		employeeLeaveRepository.deleteById(id);
		
	}

	@Override
	public List<UserLeaveRequest> findAdminByLeaveRequest(int adminID) {
		return employeeLeaveRepository.findByAdminId(adminID);
	}


	@Override
	public Optional<UserLeaveRequest> findLeaveRequestByLeaveID(int leaveID) {
		return employeeLeaveRepository.findById(leaveID);
	}


	@Override
	public UserLeaveRequest updateUserLeaveRequest(UserLeaveRequest userLeaveRequest) {
		return employeeLeaveRepository.save(userLeaveRequest);
	}


	@Override
	public List<UpdateDetails> getallUpdates() {
		return updateDetailsRepository.findAll();
	}


	@Override
	public void save(UpdateDetails updateDetails) {
		updateDetailsRepository.save(updateDetails);
	}


	@Override
	public void deleteUpdateByID(int id) {
		updateDetailsRepository.deleteById(id);
		
	}


	@Override
	public Optional<UpdateDetails> findUpdateById(int id) {
		return updateDetailsRepository.findById(id);
	}

}
