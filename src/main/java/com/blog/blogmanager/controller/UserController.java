package com.blog.blogmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.blog.blogmanager.domain.User;
import com.blog.blogmanager.service.SecurityService;
import com.blog.blogmanager.service.UserService;
import com.blog.blogmanager.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping(path = "/registration")
	public String getRegistration(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}
	
	@PostMapping(path = "/registration")
	public String postRegistration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);
		if(bindingResult.hasErrors()) {
			return "registration";
		}
		userService.save(userForm);
		securityService.autologin(userForm.getUsername(), userForm.getPassword());
		
		return "redirect:/welcome"; //if need to use session use forward
	}
	
	@GetMapping(path = "/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping(path = {"/", "/welcome"})
    public String welcome() {
        return "welcome";
    }
    
}
