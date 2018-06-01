package com.skilldistillery.swapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.swapp.service.UserService;
//Configures the app to accept all traffic from 4200 because
//Angular runs on a separate server (port 4200)
@CrossOrigin({ "*", "http://localhost:4200" })
@RestController
@RequestMapping("api")
public class UserController {
	
	@Autowired
	private UserService userServ;

	// PING() WORKS
	@RequestMapping(path = "ping", method=RequestMethod.GET)
	public String ping() {
		return "pong";
	}
}
