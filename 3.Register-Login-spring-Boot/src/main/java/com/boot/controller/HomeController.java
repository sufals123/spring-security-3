package com.boot.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.boot.model.Student;
import com.boot.repo.UserRepository;
import com.boot.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository repository;
	
	@ModelAttribute
	public void commonData(Principal p, Model m) {
		if (p != null) {
			String name = p.getName();
			Student email = repository.findByEmail(name);
			m.addAttribute("user", email);
		}
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/user/profile")
	public String profile(Principal p, Model m) {
		String student = p.getName();
		Student email = repository.findByEmail(student);
		m.addAttribute("student", email);
		return "profile";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute Student student, HttpSession session) {
		Student s = userService.saveStudent(student);
		if (s != null) {
			session.setAttribute("msg", "Registered Successfully. Please Login.");
		} else {
			session.setAttribute("msg", "Something went wrong. Please try again.");
		}
		return "redirect:/register";
	}
	
	@GetMapping("/admin/contact")
	public String admin() {
		return "admin";
	}
}
