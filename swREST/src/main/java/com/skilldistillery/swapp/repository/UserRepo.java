package com.skilldistillery.swapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.swapp.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
