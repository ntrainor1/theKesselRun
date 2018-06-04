// USER CONTROLLER WORKS DO NOT TOUCH UNTIL NEEDED FOR SECURITY
//ADDED SECURITY gc on 6/4

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

import com.skilldistillery.swapp.User;
import com.skilldistillery.swapp.service.UserService;
//Configures the app to accept all traffic from 4200 because
//Angular runs on a separate server (port 4200)
@CrossOrigin({ "*", "http://localhost:4200" })
@RestController
@RequestMapping("api")
public class UserController {
	
	@Autowired
	private UserService userService;

	// GET users WORKS
	@RequestMapping(path = "users", method=RequestMethod.GET)
	public List<User> index(HttpServletRequest req, HttpServletResponse res, Principal principal) {
		return userService.index();
	}
	// GET users/{id} WORKS
	@RequestMapping(path = "users/{id}", method=RequestMethod.GET)
	public User show(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") int id, Principal principal) {
		return userService.show(principal.getName(), id);
	}
	// POST users WORKS
	@RequestMapping(path = "users", method=RequestMethod.POST)
	public User create(HttpServletRequest req, HttpServletResponse res, @RequestBody User user, Principal principal) {
		return userService.create(user);
	}
	// PUT users/{id} WORKS
	@RequestMapping(path = "users/{id}", method=RequestMethod.PUT)
	public User update(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") int id, @RequestBody User user, Principal principal) {
		return userService.update(principal.getName(), id, user);
	}
	// DELETE users/{id}
	@RequestMapping(path = "users/{id}", method=RequestMethod.DELETE)
	public void destroy(HttpServletRequest req, HttpServletResponse res, @PathVariable int id, Principal principal) {
		userService.destroy(principal.getName(), id);
	}
}
