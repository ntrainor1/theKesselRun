package com.skilldistillery.swapp.service;

import java.util.List;

import com.skilldistillery.swapp.Inventory;
import com.skilldistillery.swapp.Item;

public interface InventoryService {
	List<Inventory> index();
	List<Inventory> getInventoryByUsername(String username);
	Inventory show(Integer id);
	Inventory create(Inventory inventory);
	Inventory update(int id, Inventory inventory);
	void destroy(int id);
	Inventory getInventoryByItem(Item item);
}
