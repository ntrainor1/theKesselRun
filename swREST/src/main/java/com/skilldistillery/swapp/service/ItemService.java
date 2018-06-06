package com.skilldistillery.swapp.service;

import java.util.List;
import java.util.Set;

import com.skilldistillery.swapp.Cart;
import com.skilldistillery.swapp.CartItem;
import com.skilldistillery.swapp.Item;

public interface ItemService {
	List<Item> index();
	Item show(Integer id);
	Item create(Item item);
	Item update(int id, Item item);
	void destroy(int id);
	CartItem addToCart(int id, Cart cart);
}
