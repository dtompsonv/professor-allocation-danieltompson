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

import com.project.professor.allocation.entity.Course;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class CourseRepositoryTest {

	@Autowired
	CourseRepository courseRepository;

	@Test
	void findAll() {
		List<Course> course = courseRepository.findAll();
		System.out.println(course);
	}

	@Test
	void findById() {
		Long id = 1l;
		Optional<Course> course = courseRepository.findById(id);
		Course crs = course.orElse(null);
		System.out.println(crs);
	}

	@Test
	void create() {
		Course crs1 = new Course();
		crs1.setName("Test");
		crs1.setId(null);
		Course crs2 = courseRepository.save(crs1);
		System.out.println(crs2);
	}

	@Test
	void update() {
		Course crs1 = new Course();
		crs1.setName("Test2");
		crs1.setId(1l);
		Course crs2 = courseRepository.save(crs1);
		System.out.println(crs2);
	}

	@Test
	void deleteById() {
		Long id = 1l;
		courseRepository.deleteById(id);
	}

	@Test
	void deleteAll() {
		courseRepository.deleteAllInBatch();
	}
}
