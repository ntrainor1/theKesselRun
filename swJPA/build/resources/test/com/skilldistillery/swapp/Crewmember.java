package com.skilldistillery.swapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Crewmember {

	// Fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	private String name;
	
	private int cost;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="crew_id")
	private Crew crew;
	
	@ManyToOne
	@JoinColumn(name="crew_role_id")
	private CrewRole role;
	// G & S
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Crew getCrew() {
		return crew;
	}
	public void setCrew(Crew crew) {
		this.crew = crew;
	}
	public CrewRole getRole() {
		return role;
	}
	public void setRole(CrewRole role) {
		this.role = role;
	}
	
	
	 public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	// CONSTRUCTORS
	public Crewmember() {};
	
	public Crewmember(int id, String name, int cost, Crew crew, CrewRole role) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.crew = crew;
		this.role = role;
	}
	// hashCode and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crew == null) ? 0 : crew.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		Crewmember other = (Crewmember) obj;
		if (crew == null) {
			if (other.crew != null)
				return false;
		} else if (!crew.equals(other.crew))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}
	
	// to String
	@Override
	public String toString() {
		return "Crewmember [id=" + id + ", name=" + name + ", crew=" + crew.getId() + ", role=" + role.getName() + "]";
	}
	
	
}
