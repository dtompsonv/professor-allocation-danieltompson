package com.project.professor.allocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professor.allocation.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	// Select * FROM department WHERE name LIKE '%?1%'
	List<Department> findByNameLikeContaining(String name);

}
