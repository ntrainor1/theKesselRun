package com.skilldistillery.swapp.service;

import java.util.Set;

import com.skilldistillery.swapp.Crewmember;

public interface CrewmemberService {
	public Set<Crewmember> index(String username);
	public Crewmember show(String username, Integer id);
	public Crewmember create(String username, Crewmember cm);
	public Crewmember update(String username, int id, Crewmember cm);
	public void destroy(String username, int id);
}
