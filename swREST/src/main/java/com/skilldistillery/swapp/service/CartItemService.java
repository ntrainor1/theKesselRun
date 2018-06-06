package com.skilldistillery.swapp.service;

import java.util.List;

import com.skilldistillery.swapp.Cart;
import com.skilldistillery.swapp.CartItem;

public interface CartItemService {
	public List<CartItem> index();
	public List<CartItem> show(Integer id);
	public CartItem update(int id, CartItem cart);
	public void destroy(int id);
	public CartItem addToCart(CartItem addingCartItem);
}
