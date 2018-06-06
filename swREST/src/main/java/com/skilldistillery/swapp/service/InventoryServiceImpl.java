package com.skilldistillery.swapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.swapp.Inventory;
import com.skilldistillery.swapp.repository.InventoryRepo;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private InventoryRepo inventoryRepo;

	@Override
	public List<Inventory> index() {
		return inventoryRepo.findAll();
	}

	@Override
	public List<Inventory> getInventoryByUsername(String username) {
		return inventoryRepo.findByUserUsername(username);
	}

	@Override
	public Inventory show(Integer id) {
		return inventoryRepo.findById(id).get();
	}

	@Override
	public Inventory create(Inventory inventory) {
		return inventoryRepo.saveAndFlush(inventory);
	}

	@Override
	public Inventory update(int id, Inventory inventory) {
		Inventory managed = inventoryRepo.findById(id).get();
		managed.setUser(inventory.getUser());
		managed.setItem(inventory.getItem());
		return inventoryRepo.saveAndFlush(managed);
	}

	@Override
	public void destroy(int id) {
		inventoryRepo.deleteById(id);
	}


}
