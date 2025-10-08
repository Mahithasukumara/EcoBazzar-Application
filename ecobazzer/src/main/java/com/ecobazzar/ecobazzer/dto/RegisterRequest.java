package com.ecobazzar.ecobazzer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {
	
	@NotBlank(message="name is a required field")
	private String name;
	@NotBlank(message="name is a required field")
    @Email(message="Email valid email")
	private String email;
	
	@NotBlank(message="name is a required field")
	@Size(min=4,message="password must be atleast 4 characters")

	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
