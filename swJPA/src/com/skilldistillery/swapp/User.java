package com.skilldistillery.swapp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User {
	// FIELDS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// G & S
	
	// ACCESS MODIFIERS
	
	// CONSTRUCTORS
	
	// HASHCODE .EQUALS TOSTRING
}
