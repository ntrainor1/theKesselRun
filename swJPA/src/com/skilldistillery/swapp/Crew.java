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
}
