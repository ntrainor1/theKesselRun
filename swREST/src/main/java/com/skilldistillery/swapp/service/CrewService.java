package com.skilldistillery.swapp.service;

import java.util.Set;

import com.skilldistillery.swapp.Crew;

public interface CrewService {
	public Set<Crew> index(String username);
	public Crew show(String username, Integer id);
	public Crew create(String username, Crew crew);
	public Crew update(String username, int id, Crew crew);
	public void destroy(String username, int id);
}
