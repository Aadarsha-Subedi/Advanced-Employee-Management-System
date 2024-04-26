package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.UpdateDetails;

@Repository
public interface UpdateDetailsRepository extends JpaRepository<UpdateDetails, Integer>{

}
