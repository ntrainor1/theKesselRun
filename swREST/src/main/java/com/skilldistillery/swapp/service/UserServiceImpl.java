package com.skilldistillery.swapp.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.swapp.User;
import com.skilldistillery.swapp.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public Set<User> index(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User show(String username, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User create(String username, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(String username, int id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy(String username, int id) {
		// TODO Auto-generated method stub
		
	}

}
