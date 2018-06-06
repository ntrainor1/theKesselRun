package com.skilldistillery.swapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.swapp.Inventory;
import com.skilldistillery.swapp.Item;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

	List<Inventory> findByUserUsername(String username);

	Inventory findByItem(Item item);

}
