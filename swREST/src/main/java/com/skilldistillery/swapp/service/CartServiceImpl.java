package com.skilldistillery.swapp.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.swapp.Cart;
import com.skilldistillery.swapp.repository.CartRepo;

public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepo cartRepo;
	
	@Override
	public Set<Cart> index(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart show(String username, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart create(String username, Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart update(String username, int id, Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy(String username, int id) {
		// TODO Auto-generated method stub
		
	}

}
