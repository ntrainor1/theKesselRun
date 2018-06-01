package com.skilldistillery.swapp.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.swapp.Crew;
import com.skilldistillery.swapp.repository.CrewRepo;

public class CrewServiceImpl implements CrewService {
	
	@Autowired
	private CrewRepo crewRepo;
	
	@Override
	public Set<Crew> index(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Crew show(String username, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Crew create(String username, Crew crew) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Crew update(String username, int id, Crew crew) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy(String username, int id) {
		// TODO Auto-generated method stub

	}

}
