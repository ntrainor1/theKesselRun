package com.skilldistillery.swapp.service;

import java.util.Set;

import com.skilldistillery.swapp.Profile;

public interface ProfileService {
	public Set<Profile> index(String username);
	public Profile show(String username, Integer id);
	public Profile create(String username, Profile profile);
	public Profile update(String username, int id, Profile profile);
	public void destroy(String username, int id);
}
