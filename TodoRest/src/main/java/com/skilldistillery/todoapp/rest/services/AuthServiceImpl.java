package com.skilldistillery.todoapp.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skilldistillery.sw.entities.User;
import com.skilldistillery.todoapp.rest.repo.UserRepo;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public User register(User user) {
		String encryptedPW = encoder.encode(user.getPassword());
		user.setPassword(encryptedPW);
		user.setEnabled(true);
		user.setRole("standard");
		userRepo.saveAndFlush(user);
		return user;
	}

}
