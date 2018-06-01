package com.skilldistillery.swapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.swapp.Profile;

public interface ProfileRepo extends JpaRepository<Profile, Integer> {

}
