// THIS WORKS WITH THE USER SERVICE REPO AND CONTROLLER

package com.skilldistillery.swapp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	// FIELDS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	private String password;
	
	private boolean admin;
	
	private boolean active;
	@JsonIgnore
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private Profile profile;

	// G & S
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public int getId() {
		return id;
	}
	// ACCESS MODIFIERS
	// CONSTRUCTORS
	public User() {};
	public User(int id, String username, String password, boolean admin, boolean active, Profile profile) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.admin = admin;
		this.active = active;
		this.profile = profile;
	}
	
	// HASHCODE .EQUALS TOSTRING
}
