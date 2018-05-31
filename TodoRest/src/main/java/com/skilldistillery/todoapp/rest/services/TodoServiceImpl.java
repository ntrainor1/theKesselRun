package com.skilldistillery.todoapp.rest.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.sw.entities.Todo;
import com.skilldistillery.sw.entities.User;
import com.skilldistillery.todoapp.rest.repo.TodoRepo;
import com.skilldistillery.todoapp.rest.repo.UserRepo;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoRepo todoRepo;
	@Autowired
	UserRepo userRepo;

	@Override
	public Set<Todo> index(String username) {
		User user = userRepo.findByUsername(username);
		return todoRepo.findByUser(user);

	}

	@Override
	public Todo show(String username, int todoId) {
		User user = userRepo.findByUsername(username);
		return todoRepo.findByUserAndId(user, todoId);
	}

	@Override
	public Todo create(String username, Todo todo) {
		User user = userRepo.findByUsername(username);
		todo.setUser(user);
		return todoRepo.saveAndFlush(todo);
	}

	@Override
	public Todo update(String username, int todoId, Todo todo) {
		User user = userRepo.findByUsername(username);
		todo.setUser(user);
		todo.setId(todoId);
		return todoRepo.saveAndFlush(todo);
	}

	@Override
	public Boolean destroy(String username, int todoId) {
		User user = userRepo.findByUsername(username);
		Todo todo = todoRepo.findById(todoId).get();
		todoRepo.delete(todo);
		if (todoRepo.existsById(todo.getId())) {
			return false;
		} else {
			return true;
		}
	}

}
