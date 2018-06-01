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

import com.skilldistillery.swapp.Crew;
import com.skilldistillery.swapp.Profile;
import com.skilldistillery.swapp.service.CrewService;
//Configures the app to accept all traffic from 4200 because
//Angular runs on a separate server (port 4200)
@CrossOrigin({ "*", "http://localhost:4200" })
@RestController
@RequestMapping("api")
public class CrewController {
	
	@Autowired
	private CrewService crewService;

	// GET profiles WORKS
	@RequestMapping(path = "crews", method=RequestMethod.GET)
	public List<Crew> index(HttpServletRequest req, HttpServletResponse res) {
		return crewService.index();
	}

	// GET profiles/{id} WORKS
	@RequestMapping(path = "crews/{profileId}", method=RequestMethod.GET)
	public Crew show(HttpServletRequest req, HttpServletResponse res, @PathVariable("profileId") int id) {
		return crewService.show(id);
	}

	// PUT profiles/{id} WORKS
	@RequestMapping(path = "crews/{id}", method=RequestMethod.PUT)
	public Crew update(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") int id, @RequestBody Crew crew) {
		return crewService.update(id, crew);
	}

}
