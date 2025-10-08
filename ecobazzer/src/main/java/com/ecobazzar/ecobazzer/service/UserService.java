package com.ecobazzar.ecobazzer.service;
import com.ecobazzar.ecobazzer.repository.UserRepository;
import com.ecobazzar.ecobazzer.model.User;


import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final UserRepository userrepo;
	public UserService(UserRepository userrepo) {
		this.userrepo=userrepo;
		
	}
	public User createUser(User user) {
		return userrepo.save(user);
	}
	public List <User> getAllUsers(){
		return userrepo.findAll();
	}
	

}
