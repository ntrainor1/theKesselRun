// USER CONTROLLER WORKS DO NOT TOUCH UNTIL NEEDED FOR SECURITY

package com.skilldistillery.swapp.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.swapp.Inventory;
import com.skilldistillery.swapp.Item;
import com.skilldistillery.swapp.service.AuthService;
import com.skilldistillery.swapp.service.InventoryService;
//Configures the app to accept all traffic from 4200 because
//Angular runs on a separate server (port 4200)
@CrossOrigin({ "*", "http://localhost:4200" })
@RestController
@RequestMapping("api")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private AuthService authService;

	// GET items WORKS
	@RequestMapping(path = "inventories", method=RequestMethod.GET)
	public List<Inventory> index(HttpServletRequest req, HttpServletResponse res, Principal principal) {
		return inventoryService.index();
	}
	
	// GET items/{id} WORKS
	@RequestMapping(path = "inventories/{username}", method=RequestMethod.GET)
	public List<Item> showItemsInInventory(HttpServletRequest req, HttpServletResponse res, @PathVariable("username") String username, Principal principal) {
		 List<Inventory> inventoryList = inventoryService.getInventoryByUsername(username);
		 List<Item> inventoryItemList = new ArrayList<>();
		 for (Inventory inventory: inventoryList) {
			 inventoryItemList.add(inventory.getItem());
		 }
		 return inventoryItemList;
	}

	@RequestMapping(path = "inventories", method=RequestMethod.POST)
	public Inventory create(HttpServletRequest req, HttpServletResponse res, @RequestBody Inventory inventory) {
		return inventoryService.create(inventory);
	}
	// PUT items/{id} WORKS
	@RequestMapping(path = "inventories/{id}", method=RequestMethod.PUT)
	public Inventory update(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") int id, @RequestBody Inventory inventory, Principal principal) {
		return inventoryService.update(id, inventory);
	}
	// DELETE items/{id}
	@RequestMapping(path = "inventories/{id}", method=RequestMethod.DELETE)
	public void destroy(HttpServletRequest req, HttpServletResponse res, @PathVariable int id, Principal principal) {
		inventoryService.destroy(id);
	}
}
