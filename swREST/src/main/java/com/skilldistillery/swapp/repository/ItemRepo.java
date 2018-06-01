package com.skilldistillery.swapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.swapp.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
