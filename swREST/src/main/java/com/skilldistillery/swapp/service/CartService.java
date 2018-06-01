package com.skilldistillery.swapp.service;

import java.util.List;

import com.skilldistillery.swapp.Cart;

public interface CartService {
	public List<Cart> index();
	public Cart show(Integer id);
	public Cart create(String username, Cart cart);
	public Cart update(String username, int id, Cart cart);
	public void destroy(String username, int id);
}
