package com.boot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.service.annotation.GetExchange;

@Controller
public class HomeController {
	
	@GetExchange("/")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String index() {
		return "index";
	}
	@GetMapping("/about")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String about() {
		return "about";
	}
	@GetMapping("/profile")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String profile() {
		return "profile";
	}
}
