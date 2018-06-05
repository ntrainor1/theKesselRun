package com.skilldistillery.swapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.swapp.Category;
import com.skilldistillery.swapp.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo catRepo;
	
	@Override
	public List<Category> index() {
		return catRepo.findAll();
	}

	@Override
	public Category show(Integer id) {
		return catRepo.findById(id).get();
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
