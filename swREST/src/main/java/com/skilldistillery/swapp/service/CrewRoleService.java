package com.skilldistillery.swapp.service;

import java.util.Set;

import com.skilldistillery.swapp.CrewRole;

public interface CrewRoleService {
	public Set<CrewRole> index(String username);
	public CrewRole show(String username, Integer id);
	public CrewRole create(String username, CrewRole cr);
	public CrewRole update(String username, int id, CrewRole cr);
	public void destroy(String username, int id);
}
