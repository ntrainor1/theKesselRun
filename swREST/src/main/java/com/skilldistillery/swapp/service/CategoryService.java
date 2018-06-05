package com.skilldistillery.swapp.service;

import java.util.List;

import com.skilldistillery.swapp.Category;


public interface CategoryService {
	public List<Category> index();
	public Category show(Integer id);
	public Category create(String username, Category cat);
	public Category update(String username, int id, Category cat);
	public void destroy(String username, int id);
}
