package com.ecobazzar.ecobazzer.controller;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecobazzar.ecobazzer.model.User;
import com.ecobazzar.ecobazzer.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userservice ;
	
	public UserController(UserService userservice) {
		this.userservice=userservice;
	}
	@PostMapping()
	public User createUser(@RequestBody User user) {
		return userservice.createUser(user);
	}
	
	@GetMapping()
	public List <User> GetAllUsers(){
		return userservice.getAllUsers();
	}
	
	
	

}
