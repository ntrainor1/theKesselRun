package com.skilldistillery.swapp.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.skilldistillery.swapp.CrewRole;
import com.skilldistillery.swapp.repository.CrewRoleRepo;

public class CrewRoleServiceImpl implements CrewRoleService {
	
	@Autowired
	private CrewRoleRepo crRepo;
	
	@Override
	public Set<CrewRole> index(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CrewRole show(String username, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CrewRole create(String username, CrewRole cr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CrewRole update(String username, int id, CrewRole cr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy(String username, int id) {
		// TODO Auto-generated method stub

	}

}
