package com.skilldistillery.swapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.swapp.Category;
import com.skilldistillery.swapp.Item;
import com.skilldistillery.swapp.repository.CategoryRepo;
import com.skilldistillery.swapp.repository.ItemRepo;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired 
	private CategoryRepo catRepo;
	
	@Override
	public List<Item> index() {
		return itemRepo.findAll();
	}

	@Override
	public Item show(Integer id) {
		return itemRepo.findById(id).get();
	}

	@Override
	public Item create(Item item) {
		if (item.getCategory() == null) {
			Category category = catRepo.findByName(item.getCategory().getName());
			item.setCategory(category);
		}
		return itemRepo.saveAndFlush(item);
	}

	@Override
	public Item update(int id, Item item) {
		Item managedItem = itemRepo.findById(id).get();
		managedItem.setCategory(item.getCategory());
		managedItem.setDescription(item.getDescription());
		managedItem.setImageUrl(item.getImageUrl());
		managedItem.setName(item.getName());
		managedItem.setPrice(item.getPrice());
		managedItem.setUser(item.getUser());
		return itemRepo.saveAndFlush(managedItem);
		
	}

	@Override
	public void destroy(int id) {
		itemRepo.delete(itemRepo.findById(id).get());
	}

}
