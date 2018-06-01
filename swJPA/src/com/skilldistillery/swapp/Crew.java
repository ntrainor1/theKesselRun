package com.skilldistillery.swapp;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Crew {
	// FIELDS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="profile_id")
	private Profile profile;
	
	@OneToMany(mappedBy="crew")
	private List<Crewmember> crewmembers;
	
	// G & S
	
	public int getId() {
		return id;
	}

	public List<Crewmember> getCrewmembers() {
		return crewmembers;
	}

	public void setCrewmembers(List<Crewmember> crewmembers) {
		this.crewmembers = crewmembers;
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

	// CONSTRUCTORS
	public Crew() {}

	public Crew(int id, Profile profile, List<Crewmember> crewmembers) {
		super();
		this.id = id;
		this.profile = profile;
		this.crewmembers = crewmembers;
	};
	
}
