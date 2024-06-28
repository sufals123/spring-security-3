package com.db.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.db.entites.User;
import com.db.repo.UserRepository;
import com.db.service.UserServiceImp;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private UserServiceImp userServiceImp;
	
	@Autowired
	private UserRepository repository;
	
	@ModelAttribute
	public void commonUser(Principal p, Model m) {
		if(p != null) {
			String email = p.getName();	
			User user = repository.findByEmail(email);
			m.addAttribute("user", user);
		}
	}
	
	@GetMapping("/")
	public String indexHandler(Model model) {
		model.addAttribute("tittle", "Contact-User");
		return "index";		
	}
	
	@GetMapping("/user/home")
	public String HomeHandler(Model model) {
		model.addAttribute("tittle", "Home-User");
		return "home";	
	}
	
	/*
	 * @GetMapping("/user/profile") public String profileHandler(Model model) {
	 * model.addAttribute("tittle", "Profile-User"); return "profile"; }
	 */
	
	@GetMapping("/singin")
	public String loginHandler(Model model) {
		model.addAttribute("tittle", "Login-User");
		return "login";		
	}
	@GetMapping("/singup")
	public String registerHandler(Model model) {
		model.addAttribute("tittle", "Register-User");
		model.addAttribute("user", new User());
		return "register";		
	}
	@PostMapping("/saveuser")
	public String SaveUserHandler(@ModelAttribute("user") User user, HttpSession http) {
	
	    User saveUser = userServiceImp.saveUser(user);
	
	    if (saveUser != null) {
	
	        http.setAttribute("msg", "User saved successfully");
	    } else {
	       
	        http.setAttribute("msg", "Something went wrong while saving user");
	    }
	    
	 
	    return "redirect:/signup";
	}

}
