package com.skilldistillery.swapp;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cart {

	// Fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@JsonIgnore
	@JoinColumn(name = "profile_id")
	private Profile profile;
	
	@JsonIgnore
	@ManyToMany
    @JoinTable(name="cart_item",
            joinColumns=@JoinColumn(name="cart_id"),
            inverseJoinColumns=@JoinColumn(name="item_id")
          )
	private List <Item> items;
	
	// Getters and Setters
	public int getId() {
		return id;
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

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Cart() {};
	public Cart(int id, Profile profile, List<Item> items) {
		super();
		this.id = id;
		this.profile = profile;
		this.items = items;
	}

	// hashCode and .equals()
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (id != other.id)
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		return true;
	}

	
	// toString
	@Override
	public String toString() {
		return "Cart [id=" + id + ", profile=" + profile.getName() + ", items=" + items.size() + "]";
	}

	
	
}
