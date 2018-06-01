package com.skilldistillery.swapp.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.swapp.Profile;
import com.skilldistillery.swapp.repository.ProfileRepo;

public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileRepo profileRepo;
	
	@Override
	public Set<Profile> index(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profile show(String username, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profile create(String username, Profile profile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profile update(String username, int id, Profile profile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy(String username, int id) {
		// TODO Auto-generated method stub

	}

}
