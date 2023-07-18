package com.project.professor.allocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.entity.Allocation;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {
	
	// SELECT * FROM allocation WHERE course_id = ?1
	
	// SELECT * FROM allocation WHERE professor_id = ?1

}
