package com.skilldistillery.todoapp.rest.controllers;

import java.security.Principal;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.sw.entities.Todo;
import com.skilldistillery.todoapp.rest.services.TodoService;

@RestController
@RequestMapping(path = "/api/")
@CrossOrigin({ "*", "http://localhost:4200" })
public class TodoController {

	@Autowired
	TodoService service;

	@RequestMapping(path = "todos", method = RequestMethod.GET)
	public Set<Todo> index(HttpServletRequest req, HttpServletResponse res, Principal principal) {
		return service.index(principal.getName());
	}

	@RequestMapping(path = "todos/{tid}", method = RequestMethod.GET)
	public Todo show(HttpServletRequest req, HttpServletResponse res, @PathVariable int tid, Principal principal) {
		return service.show(principal.getName(), tid);
	}

	@RequestMapping(path = "todos", method = RequestMethod.POST)
	public Todo create(HttpServletRequest req, HttpServletResponse res, @RequestBody Todo todo, Principal principal) {
		return service.create(principal.getName(), todo);
	}

	@RequestMapping(path = "todos/{tid}", method = RequestMethod.PUT)
	public Todo update(HttpServletRequest req, HttpServletResponse res, @PathVariable int tid, @RequestBody Todo todo, Principal principal) {
		return service.update(principal.getName(), tid, todo);
	}

	@RequestMapping(path = "todos/{tid}", method = RequestMethod.DELETE)
	public Boolean destroy(HttpServletRequest req, HttpServletResponse res, @PathVariable int tid, Principal principal) {
		return service.destroy(principal.getName(), tid);
	}
}
