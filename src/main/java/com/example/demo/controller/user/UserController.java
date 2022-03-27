package com.example.demo.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Register.UserForm;
import com.example.demo.service.Login.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController{
	
	private final UserService userService;
	
	@GetMapping
	public String showList(Model model) {
		model.addAttribute("userList", userService.findAll());
		return "Admin/users/list";
	}
	
	//GET /users/creationForm
    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute UserForm Form) {
    	return "Admin/users/creationForm";
    }
	
    //POST /users
    @PostMapping
    public String create(@Validated UserForm form, BindingResult bindingResult) {
    	if(bindingResult.hasErrors()) {
    		return showCreationForm(form);
    	}
    	userService.create(form.getUsername(),form.getPassword());
    	return "redirect:/users"; 
    }
}