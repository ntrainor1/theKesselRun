package com.skilldistillery.swapp;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Crew {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@JoinColumn(name="profile_id")
	private Profile profile;
	
	@OneToMany(mappedBy="profile")
	private List<Crewmember>crewMembers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Crewmember> getCrewMembers() {
		return crewMembers;
	}

	public void setCrewMembers(List<Crewmember> crewMembers) {
		this.crewMembers = crewMembers;
	}
	public Crew() {};
	public Crew(int id, Profile profile, List<Crewmember> crewMembers) {
		super();
		this.id = id;
		this.profile = profile;
		this.crewMembers = crewMembers;
	}
}
