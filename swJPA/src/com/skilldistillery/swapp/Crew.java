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
	@JoinColumn(name="user_id")
	private User user;
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// CONSTRUCTORS
	public Crew() {}

	public Crew(int id, User user, List<Crewmember> crewmembers) {
		super();
		this.id = id;
		this.user = user;
		this.crewmembers = crewmembers;
	};
	
}
