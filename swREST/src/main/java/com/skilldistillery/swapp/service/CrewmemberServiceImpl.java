package com.skilldistillery.swapp.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.swapp.Crewmember;
import com.skilldistillery.swapp.repository.CrewmemberRepo;

public class CrewmemberServiceImpl implements CrewmemberService {
	
	@Autowired
	private CrewmemberRepo cmRepo;
	
	@Override
	public Set<Crewmember> index(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Crewmember show(String username, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Crewmember create(String username, Crewmember cm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Crewmember update(String username, int id, Crewmember cm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy(String username, int id) {
		// TODO Auto-generated method stub
		
	}

}
