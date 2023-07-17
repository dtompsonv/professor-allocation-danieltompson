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

import com.project.professor.allocation.entity.Allocation;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationRepositoryTest {

	@Autowired
	AllocationRepository allocationRepository;

	@Test
	void findAll() {
		List<Allocation> alloc = allocationRepository.findAll();
		System.out.println(alloc);
	}

	@Test
	void findById() {
		Long id = 1l;
		Optional<Allocation> alloc = allocationRepository.findById(id);
		Allocation all = alloc.orElse(null);
		System.out.println(all);
	}

	@Test
	void create() {
		Allocation alloc1 = new Allocation();
		alloc1.setName("Test");
		alloc1.setId(null);
		Allocation alloc2 = allocationRepository.save(alloc1);
		System.out.println(alloc2);
	}

	@Test
	void update() {
		Allocation alloc1 = new Allocation();
		alloc1.setName("Test2");
		alloc1.setId(1l);
		Allocation alloc2 = allocationRepository.save(alloc1);
		System.out.println(alloc2);
	}

	@Test
	void deleteById() {
		Long id = 1l;
		allocationRepository.deleteById(id);
	}

	@Test
	void deleteAll() {
		allocationRepository.deleteAllInBatch();
	}
}
