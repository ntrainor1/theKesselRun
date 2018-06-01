package com.skilldistillery.swapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.swapp.Crewmember;
import com.skilldistillery.swapp.repository.CrewmemberRepo;
@Service
public class CrewmemberServiceImpl implements CrewmemberService {
	
	@Autowired
	private CrewmemberRepo cmRepo;
	
	@Override
	public List<Crewmember> index() {
		return cmRepo.findAll();
	}

	@Override
	public Crewmember show(Integer id) {
		return cmRepo.findById(id).get();
	}

	@Override
	public Crewmember create(Crewmember cm) {
		return cmRepo.saveAndFlush(cm);
	}

	@Override
	public Crewmember update(int id, Crewmember cm) {
		Crewmember managedCm = cmRepo.findById(id).get();
		managedCm.setCrew(cm.getCrew());
		managedCm.setName(cm.getName());
		managedCm.setRole(cm.getRole());
		return cmRepo.saveAndFlush(managedCm);
	}

	@Override
	public void destroy(int id) {
		cmRepo.deleteById(id);
	}

}
