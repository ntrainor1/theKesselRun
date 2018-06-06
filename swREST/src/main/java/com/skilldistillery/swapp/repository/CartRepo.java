package com.skilldistillery.swapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.swapp.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>{

	Optional<Cart> findByUserUsername(String username);

}
