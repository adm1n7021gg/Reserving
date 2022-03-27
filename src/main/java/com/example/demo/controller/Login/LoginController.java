package com.example.demo.controller.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping
	public String top() {return "User/top";}
	
	@GetMapping("/login")
	public String login() {
		return "Login/login";
	}
	
	@GetMapping("/logout")
	public String showLogoutForm() {
		return "Login/logout";
	}


}