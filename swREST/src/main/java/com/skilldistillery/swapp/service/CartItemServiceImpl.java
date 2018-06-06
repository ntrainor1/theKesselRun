package com.skilldistillery.swapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.swapp.CartItem;
import com.skilldistillery.swapp.User;
import com.skilldistillery.swapp.repository.CartItemRepo;
import com.skilldistillery.swapp.repository.UserRepo;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CartItemRepo cartItemRepo;
	@Autowired
	private UserRepo userRepo;
	
	
	@Override
	public List<CartItem> index() {
		return cartItemRepo.findAll();
	}
	@Override
	public List<CartItem> show(Integer userId) {
		return cartItemRepo.findByCartUserId(userId);
	}
	@Override
	public CartItem update(int id, CartItem cartItem) {
		CartItem managed = cartItemRepo.findById(id).get();
		managed.setItem(cartItem.getItem());
		managed.setCart(cartItem.getCart());
		return cartItemRepo.saveAndFlush(managed);
	}
	@Override
	public void destroy(int id) {
		// TODO Auto-generated method stub
		cartItemRepo.delete(cartItemRepo.findById(id).get());
	}
	
	@Override
	public CartItem addToCart(CartItem addingCartItem) {
		System.out.println(addingCartItem);
		return cartItemRepo.saveAndFlush(addingCartItem);
	}
	@Override
	public void checkout(int userid, CartItem cartItem) {
		User owner = userRepo.findById(cartItem.getItem().getUser().getId()).get();
		User purchaser = userRepo.findById(userid).get();
		purchaser.setCredits(purchaser.getCredits()-cartItem.getItem().getPrice());
		
	}
	
}