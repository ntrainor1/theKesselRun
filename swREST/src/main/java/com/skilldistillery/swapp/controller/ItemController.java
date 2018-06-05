// USER CONTROLLER WORKS DO NOT TOUCH UNTIL NEEDED FOR SECURITY

package com.skilldistillery.swapp.controller;

import java.security.Principal;
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

import com.skilldistillery.swapp.Item;
import com.skilldistillery.swapp.service.AuthService;
import com.skilldistillery.swapp.service.ItemService;
//Configures the app to accept all traffic from 4200 because
//Angular runs on a separate server (port 4200)
@CrossOrigin({ "*", "http://localhost:4200" })
@RestController
@RequestMapping("api")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private AuthService authService;

	// GET items WORKS
	@RequestMapping(path = "items", method=RequestMethod.GET)
	public List<Item> index(HttpServletRequest req, HttpServletResponse res, Principal principal) {
		return itemService.index();
	}
	// GET items/{id} WORKS
	@RequestMapping(path = "items/{id}", method=RequestMethod.GET)
	public Item show(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") int id, Principal principal) {
		return itemService.show(id);
	}
	// POST items WORKS
	@RequestMapping(path = "items", method=RequestMethod.POST)
	public Item create(HttpServletRequest req, HttpServletResponse res, @RequestBody Item item, Principal principal) {
		return itemService.create(item);
	}
	// PUT items/{id} WORKS
	@RequestMapping(path = "items/{id}", method=RequestMethod.PUT)
	public Item update(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") int id, @RequestBody Item item, Principal principal) {
		return itemService.update(id, item);
	}
	// DELETE items/{id}
	@RequestMapping(path = "items/{id}", method=RequestMethod.DELETE)
	public void destroy(HttpServletRequest req, HttpServletResponse res, @PathVariable int id, Principal principal) {
		itemService.destroy(id);
	}
}
