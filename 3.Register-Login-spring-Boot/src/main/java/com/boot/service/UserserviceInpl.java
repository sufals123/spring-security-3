package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.boot.model.Student;
import com.boot.repo.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class UserserviceInpl implements UserService{
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Student saveStudent(Student student) {
		
		String encode = passwordEncoder.encode(student.getPassword());
		student.setPassword(encode);
		student.setRole("ROLE_USER");
		
		
		Student save = this.repository.save(student);
		
		return save;
	}

	@Override
	public void removeSessionMessage() {

		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();
		session.removeAttribute("msg");
		
	}
	
	
}
