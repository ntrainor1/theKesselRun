package com.skilldistillery.swapp.service;


import java.util.List;

import com.skilldistillery.swapp.Crewmember;

public interface CrewmemberService {
	public List<Crewmember> index();
	public Crewmember show(Integer id);
	public Crewmember create(Crewmember cm);
	public Crewmember update(int id, Crewmember cm);
	public void destroy(int id);
}
