package com.project.professor.allocation.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentRepositoryTest {

	@Autowired
	DepartmentRepository departmentRepository;

	@Test
	void findAll() {
		List<Department> depart = departmentRepository.findAll();
		System.out.println(depart);
	}
	
	@Test
	void findById() {
		Long id = 1l;
		Optional<Department> depart = departmentRepository.findById(id);
		Department dpt = depart.orElse(null);
		System.out.println(dpt);
	}
	
	@Test
	void create() {
		Department dpt1 = new Department();
		dpt1.setName("Test");
		dpt1.setId(null);
		Department dpt2 = departmentRepository.save(dpt1);
		System.out.println(dpt2);	
	}
	
	@Test
	void update() {
		Department dpt1 = new Department();
		dpt1.setName("Test2");
		dpt1.setId(1l);
		Department dpt2 = departmentRepository.save(dpt1);
		System.out.println(dpt2);		
	}
	
	@Test
	void deleteById() {
		Long id = 1l;
		departmentRepository.deleteById(id);
	}
	
	@Test
	void deleteAll() {
		departmentRepository.deleteAllInBatch();
	}
}