package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.UserDetails;

@Repository
public interface EmployeeRepository extends JpaRepository<UserDetails, Integer>{
	
	
}
