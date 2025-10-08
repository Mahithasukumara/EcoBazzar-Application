package com.ecobazzar.ecobazzer.dto;

public class UserResponse {
	private long id;
	private String name;
	private String email;
	private String role;
	private Integer ecoscore;
	public UserResponse(long id, String name, String email, String role, Integer ecoscore) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.ecoscore = ecoscore;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getEcoscore() {
		return ecoscore;
	}
	public void setEcoscore(Integer ecoscore) {
		this.ecoscore = ecoscore;
	}
	
	
	

}
