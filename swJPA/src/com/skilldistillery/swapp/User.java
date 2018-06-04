// THIS WORKS WITH THE USER SERVICE REPO AND CONTROLLER

package com.skilldistillery.swapp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	
	@Column(name="image_url")
	private String imageUrl;
	
	private int credits;
	
	private String species;
	
	// END FIELDS
	
	
	@OneToOne(mappedBy="profile", cascade=CascadeType.ALL)
	private Cart cart;
	
	@OneToOne(mappedBy="profile", cascade=CascadeType.ALL)
	private Crew crew;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Crew getCrew() {
		return crew;
	}

	public void setCrew(Crew crew) {
		this.crew = crew;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
	// END GET SETs

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", enabled="
				+ enabled + ", imageUrl=" + imageUrl + ", credits=" + credits + ", cart=" + cart + ", crew=" + crew
				+ ", species=" + species + "]";
	}
	
	private User() {}

	public User(int id, String username, String password, String role, boolean enabled, String imageUrl, int credits,
			Cart cart, Crew crew, String species) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
		this.imageUrl = imageUrl;
		this.credits = credits;
		this.cart = cart;
		this.crew = crew;
		this.species = species;
	}
	

		// HASHCODE .EQUALS TOSTRING
}
