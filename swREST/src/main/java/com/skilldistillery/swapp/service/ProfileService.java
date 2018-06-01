package com.skilldistillery.swapp.service;

import java.util.List;
import java.util.Set;

import com.skilldistillery.swapp.Profile;
import com.skilldistillery.swapp.User;

public interface ProfileService {
	public List<Profile> index();
	public Profile show(Integer id);
	public Profile create(Profile profile);
	public Profile update(int id, Profile profile);
	public void destroy(int id);
}
