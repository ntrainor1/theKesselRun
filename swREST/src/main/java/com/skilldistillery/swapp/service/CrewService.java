package com.skilldistillery.swapp.service;

import java.util.List;

import com.skilldistillery.swapp.Crew;

public interface CrewService {
	public List<Crew> index();
	public Crew show(Integer profileId);
	public Crew update(int crewId, Crew crew);

}
