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

import com.project.professor.allocation.entity.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorRepositoryTest {

	@Autowired
	ProfessorRepository professorRepository;

	@Test
	public void findAll() {
		List<Professor> profes = professorRepository.findAll();
		System.out.println(profes);
	}

	@Test
	public void findById() {
		Long id = 1l;
		Optional<Professor> profes = professorRepository.findById(id);
		Professor prf = profes.orElse(null);
		System.out.println(prf);
	}

	@Test
	public void create() {
		Professor prof1 = new Professor();
		prof1.setName("Test");
		prof1.setId(null);
		Professor prof2 = professorRepository.save(prof1);
		System.out.println(prof2);
	}

	@Test
	public void update() {
		Professor prof1 = new Professor();
		prof1.setName("Test2");
		prof1.setId(1l);
		Professor prof2 = professorRepository.save(prof1);
		System.out.println(prof2);
	}

	@Test
	public void deleteById() {
		Long id = 1l;
		professorRepository.deleteById(id);
	}

	@Test
	public void deleteAll() {
		professorRepository.deleteAllInBatch();
	}
}
