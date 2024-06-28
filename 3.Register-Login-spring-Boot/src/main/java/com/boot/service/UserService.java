package com.boot.service;

import com.boot.model.Student;

public interface UserService {
	
	public Student saveStudent(Student student);
	public void removeSessionMessage();
	
}
