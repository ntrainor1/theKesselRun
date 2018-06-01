package com.skilldistillery.swapp.service;

import java.util.Set;

import com.skilldistillery.swapp.Cart;

public interface CartService {
	public Set<Cart> index(String username);
	public Cart show(String username, Integer id);
	public Cart create(String username, Cart cart);
	public Cart update(String username, int id, Cart cart);
	public void destroy(String username, int id);
}
