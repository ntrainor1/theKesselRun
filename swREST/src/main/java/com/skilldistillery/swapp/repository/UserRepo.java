// USER REPO WORKS DO NOT TOUCH

package com.skilldistillery.swapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.swapp.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

	void deleteByUsername(String username);

}
