package com.ecobazzar.ecobazzer.service;


import org.springframework.stereotype.Service;

import com.ecobazzar.ecobazzer.dto.LoginRequest;
import com.ecobazzar.ecobazzer.dto.RegisterRequest;
import com.ecobazzar.ecobazzer.dto.UserResponse;
import com.ecobazzar.ecobazzer.model.User;
import com.ecobazzar.ecobazzer.repository.UserRepository;

@Service
public class AuthService {
	private final UserRepository userrepo;
	public AuthService(UserRepository userrepo) {
		
		this.userrepo=userrepo;
	}
	public UserResponse register(RegisterRequest request) {
		boolean existing=userrepo.existsByEmail(request.getEmail());
		if(existing) {
			throw new RuntimeException("Email already taken");
		}
		User user=new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setRole("Customer");
		user.setEcoscore(0);
		userrepo.save(user);
		return new UserResponse(
				user.getId(),
				user.getName(),
				user.getEmail(),
				user.getRole(),
				user.getEcoscore());
				
		
	}
	public UserResponse login(LoginRequest request) {
		User user=userrepo.findByEmail(request.getEmail())
				.orElseThrow(()->new RuntimeException("User not found"));
			if(!user.getPassword().equals(request.getPassword())) {
				throw new RuntimeException("Invalid password");
			}
		return new UserResponse(
				user.getId(),
				user.getName(),
				user.getEmail(),
				user.getRole(),
				user.getEcoscore()
				);
		
	}

}
