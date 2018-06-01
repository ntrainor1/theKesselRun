package com.skilldistillery.swapp.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.swapp.Category;
import com.skilldistillery.swapp.repository.CategoryRepo;

public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo catRepo;
	
	@Override
	public Set<Category> index(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category show(String username, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category create(String username, Category cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category update(String username, int id, Category cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy(String username, int id) {
		// TODO Auto-generated method stub

	}

}
