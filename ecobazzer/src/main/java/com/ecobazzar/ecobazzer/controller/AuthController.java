package com.ecobazzar.ecobazzer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecobazzar.ecobazzer.dto.LoginRequest;
import com.ecobazzar.ecobazzer.dto.RegisterRequest;
import com.ecobazzar.ecobazzer.dto.UserResponse;
import com.ecobazzar.ecobazzer.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/auth")
public class AuthController {
	private final AuthService authservice;
	public AuthController(AuthService authservice) {
		this.authservice=authservice;
	}
	@PostMapping("/login")
	public ResponseEntity<UserResponse> register(@Valid @RequestBody LoginRequest request ) {
		return ResponseEntity.ok(authservice.login(request));
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserResponse>login(@Valid @RequestBody RegisterRequest request){
		return ResponseEntity.ok(authservice.register(request));
	}
	
	
	

}
