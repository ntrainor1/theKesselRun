package com.skilldistillery.swapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.swapp.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	Category findByName(String name);
}
