//// THIS WORKS WITH USER SERVICE REPO AND CONTROLLER
//
//package com.skilldistillery.swapp;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
//import javax.persistence.OneToOne;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//@Entity
//public class Profile {
//	// FIELDS
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	
//	@Column(name="image_url")
//	private String imageUrl;
//	
//	private String name;
//	
//
//	@OneToOne(mappedBy="profile", cascade=CascadeType.ALL)
//	private Cart cart;
//	
//	private int credits;
//	
//	@OneToOne(mappedBy="profile", cascade=CascadeType.ALL)
//	private Crew crew;
//	
//	private String species;
//	
//	@OneToOne
//	@JoinColumn(name="user_id")
//	private User user;
//	
//	@JsonIgnore
//	@ManyToMany(mappedBy = "profiles")
//	private List<Item> items;
//	// G & S
//	
//	public String getImageUrl() {
//		return imageUrl;
//	}
//
//	public Crew getCrew() {
//		return crew;
//	}
//
//	public void setCrew(Crew crew) {
//		this.crew = crew;
//	}
//
//	public void setImageUrl(String imageUrl) {
//		this.imageUrl = imageUrl;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getCredits() {
//		return credits;
//	}
//
//	public void setCredits(int credits) {
//		this.credits = credits;
//	}
//
//	public String getSpecies() {
//		return species;
//	}
//
//	public void setSpecies(String species) {
//		this.species = species;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public List<Item> getItems() {
//		return items;
//	}
//
//	public void setItems(List<Item> items) {
//		this.items = items;
//	}
//
//	public int getId() {
//		return id;
//	}
//	
//	
//
//	public Cart getCart() {
//		return cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}
//
//	// CONSTRUCTORS
//	public Profile() {}
//
//	public Profile(int id, String imageUrl, String name, Cart cart, int credits, Crew crew, String species, User user,
//			List<Item> items) {
//		super();
//		this.id = id;
//		this.imageUrl = imageUrl;
//		this.name = name;
//		this.cart = cart;
//		this.credits = credits;
//		this.crew = crew;
//		this.species = species;
//		this.user = user;
//		this.items = items;
//	}
//
//
//	
//	
//	// ACCESS MODIFIERS
//	
//	// HASHCODE .EQUALS TOSTRING
//	
//}
