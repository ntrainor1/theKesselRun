package com.skilldistillery.swapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.swapp.Crew;

public interface CrewRepo extends JpaRepository<Crew, Integer> {

	Crew findByProfileId(Integer profileId);


}
