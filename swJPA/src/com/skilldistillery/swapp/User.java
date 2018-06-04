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
	
	private String role;
	
	private boolean enabled;
	
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
	public User(int id, String username, String password, String role, boolean enabled, Profile profile) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
		this.profile = profile;
	}
	
	// HASHCODE .EQUALS TOSTRING
}
