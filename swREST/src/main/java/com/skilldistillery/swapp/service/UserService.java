// USER SERVICE WORKS DO NOT TOUCH

package com.skilldistillery.swapp.service;

import java.util.List;

import com.skilldistillery.swapp.User;

public interface UserService {
	public List<User> index();
	public User show(String username, Integer id);
	public User create(User user);
	public User update(String username, int id, User user);
	public void destroy(String username, int id);
	public User showByUsername(String username);
	public User updateByUsername(String name, String username, User user);
}
