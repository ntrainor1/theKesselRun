// USER SERVICE IMPL WORKS DO NOT TOUCH

package com.skilldistillery.swapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.swapp.Profile;
import com.skilldistillery.swapp.User;
import com.skilldistillery.swapp.repository.ProfileRepo;
import com.skilldistillery.swapp.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ProfileRepo profileRepo;
	
	@Override
	public List<User> index() {
		return userRepo.findAll();
	}

	@Override
	public User show(Integer id) {
		return userRepo.findById(id).get();
	}

	@Override
	public User create(User user) {
		Profile p = new Profile();
		p.setImageUrl("http://icons.iconarchive.com/icons/sensibleworld/starwars/1024/Stormtrooper-icon.png");
		p.setName(user.getUsername());
		p.setCredits(10000);
		p.setUser(user);
		user.setAdmin(false);
		user.setActive(true);
		user.setProfile(p);
		return userRepo.saveAndFlush(user);
	}

	@Override
	public User update(int id, User user) {
		User managedUser = userRepo.findById(id).get();
		managedUser.setActive(user.isActive());
		managedUser.setAdmin(user.isAdmin());
		managedUser.setPassword(user.getPassword());
		managedUser.setProfile(user.getProfile());
		managedUser.setUsername(user.getUsername());
		return userRepo.saveAndFlush(managedUser);
	}

	@Override
	public void destroy(int id) {
		profileRepo.deleteById(userRepo.findById(id).get().getProfile().getId());
		userRepo.deleteById(id);
	}

}
