package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.AdminDetails;
import com.example.demo.Entity.UserDetails;

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
	
}
