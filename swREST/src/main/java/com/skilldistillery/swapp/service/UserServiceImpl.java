// USER SERVICE IMPL WORKS DO NOT TOUCH

package com.skilldistillery.swapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.swapp.Cart;
import com.skilldistillery.swapp.Crew;
import com.skilldistillery.swapp.User;
import com.skilldistillery.swapp.repository.CartRepo;
import com.skilldistillery.swapp.repository.CrewRepo;
import com.skilldistillery.swapp.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private CrewRepo crewRepo;
	
	@Override
	public List<User> index() {
		return userRepo.findAll();
	}

	@Override
	public User show(String username, Integer id) {
		return userRepo.findByUsername(username).get();
	}

	@Override
	public User create(User user) {
		Cart cart = new Cart();
		Crew crew = new Crew();
		user.setImageUrl("http://icons.iconarchive.com/icons/sensibleworld/starwars/1024/Stormtrooper-icon.png");
		user.setCredits(10000);
		cart.setUser(user);;
		crew.setUser(user);
		user.setCart(cart);
		user.setCrew(crew);
		user.setSpecies("human");
		user.setRole("standard");
		user.setEnabled(true);
		userRepo.saveAndFlush(user);
		return user;
	}

	@Override
	public User update(String username, int id, User user) {
		User managedUser = userRepo.findByUsername(username).get();
		managedUser.setEnabled(user.isEnabled());
		managedUser.setRole(user.getRole());
		managedUser.setPassword(user.getPassword());
		managedUser.setUsername(user.getUsername());
		managedUser.setImageUrl(user.getImageUrl());
		managedUser.setSpecies(user.getSpecies());
		return userRepo.saveAndFlush(managedUser);
	}

	@Override
	public void destroy(String username, int id) {
		userRepo.deleteById(id);
	}

	@Override
	public User showByUsername(String username) {
		return userRepo.findByUsername(username).get();
	}

	@Override
	public User updateByUsername(String name, String username, User user) {
		User managedUser = userRepo.findByUsername(username).get();
		managedUser.setEnabled(user.isEnabled());
		managedUser.setRole(user.getRole());
		managedUser.setPassword(user.getPassword());
		managedUser.setUsername(user.getUsername());
		managedUser.setImageUrl(user.getImageUrl());
		managedUser.setSpecies(user.getSpecies());
		return userRepo.saveAndFlush(managedUser);	}

}
