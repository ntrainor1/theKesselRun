package com.skilldistillery.swapp.service;

import java.util.Set;

import com.skilldistillery.swapp.User;

public interface UserService {
	public Set<User> index(String username);
	public User show(String username, Integer id);
	public User create(String username, User user);
	public User update(String username, int id, User user);
	public void destroy(String username, int id);
}
