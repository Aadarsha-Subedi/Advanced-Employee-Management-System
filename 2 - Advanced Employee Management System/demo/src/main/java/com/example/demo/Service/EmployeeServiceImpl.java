package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.AdminDetails;
import com.example.demo.Entity.UserDetails;
import com.example.demo.Repository.AdminRepository;
import com.example.demo.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
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

}
