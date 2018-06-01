package com.skilldistillery.swapp;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Profile {
	// FIELDS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "profiles")
	private List<Item> items;
	// G & S
	
	// ACCESS MODIFIERS
	
	// CONSTRUCTORS
	
	// HASHCODE .EQUALS TOSTRING
}
