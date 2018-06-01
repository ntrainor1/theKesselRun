package com.skilldistillery.swapp.service;

import java.util.Set;

import com.skilldistillery.swapp.Item;

public interface ItemService {
	public Set<Item> index(String username);
	public Item show(String username, Integer id);
	public Item create(String username, Item item);
	public Item update(String username, int id, Item item);
	public void destroy(String username, int id);
}
