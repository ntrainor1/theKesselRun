package com.skilldistillery.swapp.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.swapp.Item;
import com.skilldistillery.swapp.repository.ItemRepo;

public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Override
	public Set<Item> index(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item show(String username, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item create(String username, Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item update(String username, int id, Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy(String username, int id) {
		// TODO Auto-generated method stub

	}

}
