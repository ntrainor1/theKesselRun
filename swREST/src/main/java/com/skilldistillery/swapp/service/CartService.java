package com.skilldistillery.swapp.service;

import java.util.List;

import com.skilldistillery.swapp.Cart;

public interface CartService {
	public List<Cart> index();
	public Cart show(Integer id);
	public Cart update(int id, Cart cart);
}
