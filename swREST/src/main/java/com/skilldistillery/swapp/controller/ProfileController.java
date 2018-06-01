// USER CONTROLLER WORKS DO NOT TOUCH UNTIL NEEDED FOR SECURITY

package com.skilldistillery.swapp.controller;

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

import com.skilldistillery.swapp.Profile;
import com.skilldistillery.swapp.User;
import com.skilldistillery.swapp.service.ProfileService;
//Configures the app to accept all traffic from 4200 because
//Angular runs on a separate server (port 4200)
@CrossOrigin({ "*", "http://localhost:4200" })
@RestController
@RequestMapping("api")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;

	// PING() WORKS
	@RequestMapping(path = "ping", method=RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	// GET users WORKS
	@RequestMapping(path = "profiles", method=RequestMethod.GET)
	public List<Profile> index(HttpServletRequest req, HttpServletResponse res) {
		return profileService.index();
	}

	// GET users/{id} WORKS
	@RequestMapping(path = "profiles/{id}", method=RequestMethod.GET)
	public Profile show(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") int id) {
		return profileService.show(id);
	}
	// POST users WORKS
	@RequestMapping(path = "profiles", method=RequestMethod.POST)
	public Profile create(HttpServletRequest req, HttpServletResponse res, @RequestBody Profile profile) {
		return profileService.create(profile);
	}
	// PUT users/{id} WORKS
	@RequestMapping(path = "profiles/{id}", method=RequestMethod.PUT)
	public Profile update(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") int id, @RequestBody Profile profile) {
		return profileService.update(id, profile);
	}
	// DELETE users/{id}
	@RequestMapping(path = "profiles/{id}", method=RequestMethod.DELETE)
	public void destroy(HttpServletRequest req, HttpServletResponse res, @PathVariable int id) {
		profileService.destroy(id);
	}
}
