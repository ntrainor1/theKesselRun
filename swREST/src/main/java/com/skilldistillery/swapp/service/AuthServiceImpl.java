package com.skilldistillery.swapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilldistillery.swapp.User;
import com.skilldistillery.swapp.repository.UserRepo;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public User register(String json) {
		ObjectMapper om = new ObjectMapper();
		User user = null;

		try {
			user = om.readValue(json, User.class);
			String encodedPW = encoder.encode(user.getPassword());
			user.setPassword(encodedPW); 
			user =  userService.create(user);
			
		} catch (Exception e) {
			System.out.println(e);
		}		
		return user;
		
	}


}
