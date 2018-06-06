// THIS WORKS WITH THE USER SERVICE REPO AND CONTROLLER

package com.skilldistillery.swapp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Inventory> inventory;
	
	private int credits;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private Cart cart;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private Crew crew;
	
	private String species;
	// END FIELDS
	

	public int getId() {
		return id;
	}

	public List<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory(List<Inventory> inventory) {
		this.inventory = inventory;
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
	
	
	private User() {}

	public User(int id, String username, String password, String role, boolean enabled, String imageUrl,
			List<Inventory> inventory, int credits, Cart cart, Crew crew, String species) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
		this.imageUrl = imageUrl;
		this.inventory = inventory;
		this.credits = credits;
		this.cart = cart;
		this.crew = crew;
		this.species = species;
	}

	
	

		// HASHCODE .EQUALS TOSTRING
}
