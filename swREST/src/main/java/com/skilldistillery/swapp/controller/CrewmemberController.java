//Crewmember controller is working.
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

import com.skilldistillery.swapp.Crewmember;
import com.skilldistillery.swapp.User;
import com.skilldistillery.swapp.service.CrewmemberService;

@CrossOrigin({ "*", "http://localhost:4200" })
@RestController
@RequestMapping("api")
public class CrewmemberController {
	
@Autowired
private CrewmemberService cmService;

@RequestMapping(path = "crewmember/ping", method=RequestMethod.GET)
public String ping() {
	return "pong";
}

@RequestMapping(path = "crewmembers", method=RequestMethod.GET)
public List<Crewmember> index(HttpServletRequest req, HttpServletResponse res) {
	return cmService.index();
}

@RequestMapping(path = "crewmembers/{id}", method=RequestMethod.GET)
public Crewmember show(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") int id) {
	return cmService.show(id);
}

@RequestMapping(path = "crewmembers", method=RequestMethod.POST)
public Crewmember create(HttpServletRequest req, HttpServletResponse res, @RequestBody Crewmember cm) {
	return cmService.create(cm);
}

@RequestMapping(path = "crewmembers/{id}", method=RequestMethod.PUT)
public Crewmember update(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") int id, @RequestBody Crewmember cm) {
	return cmService.update(id, cm);
}

@RequestMapping(path = "crewmembers/{id}", method=RequestMethod.DELETE)
public void destroy(HttpServletRequest req, HttpServletResponse res, @PathVariable int id) {
	cmService.destroy(id);
}
}
