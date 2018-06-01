package com.skilldistillery.swapp.service;

import java.util.Set;

import com.skilldistillery.swapp.Category;


public interface CategoryService {
	public Set<Category> index(String username);
	public Category show(String username, Integer id);
	public Category create(String username, Category cat);
	public Category update(String username, int id, Category cat);
	public void destroy(String username, int id);
}
