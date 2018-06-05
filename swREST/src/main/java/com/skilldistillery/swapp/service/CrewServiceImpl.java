package com.skilldistillery.swapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.swapp.Crew;
import com.skilldistillery.swapp.repository.CrewRepo;

@Service
public class CrewServiceImpl implements CrewService {
	
	@Autowired
	private CrewRepo crewRepo;

	@Override
	public List<Crew> index() {
		return crewRepo.findAll();
	}

	@Override
	public Crew show(Integer userId) {
		return crewRepo.findByUserId(userId);
	}

	@Override
	public Crew update(int crewId, Crew crew) {
		Crew managedCrew = crewRepo.findById(crewId).get();
		managedCrew.setCrewmembers(crew.getCrewmembers());
		managedCrew.setUser(crew.getUser());
		managedCrew.setId(crew.getId());
		return crewRepo.saveAndFlush(managedCrew);
	}
	


}
