package com.skilldistillery.swapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.swapp.Crewmember;

public interface CrewmemberRepo extends JpaRepository<Crewmember, Integer> {

}
