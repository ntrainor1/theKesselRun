// USER SERVICE WORKS DO NOT TOUCH

package com.skilldistillery.swapp.service;

import java.util.List;

import com.skilldistillery.swapp.User;

public interface UserService {
	public List<User> index();
	public User show(Integer id);
	public User create(User user);
	public User update(int id, User user);
	public void destroy(int id);
}
