package com.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.model.Student;

public interface UserRepository extends JpaRepository<Student, Integer>{

	
	public Student findByEmail(String email);
}
