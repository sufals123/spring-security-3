package com.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.boot.entity.Employee;


public interface EmpRepository extends JpaRepository<Employee, Integer> {
	
	public Employee findByEmail(String email);
}
