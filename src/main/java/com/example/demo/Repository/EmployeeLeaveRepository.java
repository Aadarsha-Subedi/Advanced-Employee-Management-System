package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.UserLeaveRequest;

@Repository
public interface EmployeeLeaveRepository extends JpaRepository<UserLeaveRequest, Integer>{

	List<UserLeaveRequest> findByEmployee_Id(int userId);
	
	List<UserLeaveRequest> findByAdminId(int adminID);
	
}
