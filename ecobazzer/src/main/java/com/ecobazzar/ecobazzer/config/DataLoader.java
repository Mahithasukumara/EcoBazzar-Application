package com.ecobazzar.ecobazzer.config;

import com.ecobazzar.ecobazzer.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecobazzar.ecobazzer.model.User;


@Component
public class DataLoader implements CommandLineRunner{
	private final UserRepository userrepo;
	public DataLoader(UserRepository userrepo) {
		this.userrepo=userrepo;
	}
	@Override
	//variable arg
	public void run(String... args) {
		if(userrepo.count()==0) {
			
			User user  = new User();
			user.setName("Mahitha");
			user.setEmail("mahissk@gmail.com");
			user.setPassword("123");
			user.setRole("Developer");
			user.setEcoscore(500);
			userrepo.save(user);
			System.out.println("user saved"+user);
			
		}
	}
	
	
	
}
