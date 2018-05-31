package com.skilldistillery.todoapp.rest.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.skilldistillery.sw.entities.Todo;

public interface TodoService {

	public Set<Todo> index(String username);

	public Todo show(String username, int todoId);

	public Todo create(String username, Todo todo);

	public Todo update(String username, int todoId, Todo todo);

	public Boolean destroy(String username, int todoId);

}
