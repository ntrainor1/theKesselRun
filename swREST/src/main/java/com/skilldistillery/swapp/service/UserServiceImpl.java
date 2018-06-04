// USER SERVICE IMPL WORKS DO NOT TOUCH

package com.skilldistillery.swapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.swapp.Cart;
import com.skilldistillery.swapp.Crew;
import com.skilldistillery.swapp.Profile;
import com.skilldistillery.swapp.User;
import com.skilldistillery.swapp.repository.CartRepo;
import com.skilldistillery.swapp.repository.CrewRepo;
import com.skilldistillery.swapp.repository.ProfileRepo;
import com.skilldistillery.swapp.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ProfileRepo profileRepo;
	
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
		Profile profile = new Profile();
		Cart cart = new Cart();
		Crew crew = new Crew();
		profile.setImageUrl("http://icons.iconarchive.com/icons/sensibleworld/starwars/1024/Stormtrooper-icon.png");
		profile.setName(user.getUsername());
		profile.setCredits(10000);
		profile.setUser(user);
		cart.setProfile(profile);
		crew.setProfile(profile);
		profile.setCart(cart);
		profile.setCrew(crew);
		user.setRole("standard");
		user.setEnabled(true);
		user.setProfile(profile);
		userRepo.saveAndFlush(user);
		profileRepo.saveAndFlush(profile);
		return user;
	}

	@Override
	public User update(String username, int id, User user) {
		User managedUser = userRepo.findByUsername(username).get();
		managedUser.setEnabled(user.isEnabled());
		managedUser.setRole(user.getRole());
		managedUser.setPassword(user.getPassword());
		managedUser.setProfile(user.getProfile());
		managedUser.setUsername(user.getUsername());
		return userRepo.saveAndFlush(managedUser);
	}

	@Override
	public void destroy(String username, int id) {
		crewRepo.deleteById(userRepo.findByUsername(username).get().getProfile().getCrew().getId());
		cartRepo.deleteById(userRepo.findByUsername(username).get().getProfile().getCart().getId());
		profileRepo.deleteById(userRepo.findByUsername(username).get().getProfile().getId());
		userRepo.deleteByUsername(username);
	}

}
