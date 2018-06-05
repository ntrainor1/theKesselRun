package com.skilldistillery.swapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.swapp.CartItem;

public interface CartItemRepo extends JpaRepository<CartItem, Integer>{

	List<CartItem> findByCartUserId(Integer userId);

}
