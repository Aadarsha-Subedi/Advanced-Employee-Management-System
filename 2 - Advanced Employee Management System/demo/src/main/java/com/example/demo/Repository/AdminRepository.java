package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.AdminDetails;

public interface AdminRepository extends JpaRepository<AdminDetails, Integer>{

}
