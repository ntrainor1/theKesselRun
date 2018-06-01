package com.skilldistillery.swapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.swapp.Cart;
import com.skilldistillery.swapp.repository.CartRepo;
import com.skilldistillery.swapp.repository.ProfileRepo;

public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepo cartRepo;
	@Autowired
	private ProfileRepo profileRepo;
	
	@Override
	public List<Cart> index() {
		return cartRepo.findAll();
	}

	@Override
	public Cart show(Integer id) {
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
