//CARTController works, need to check updates when further along
package com.skilldistillery.swapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.swapp.CartItem;
import com.skilldistillery.swapp.service.CartItemService;

@CrossOrigin({ "*", "http://localhost:4200" })
@RestController
@RequestMapping("api")
public class CartItemController {
	@Autowired
	private CartItemService cartItemService;

	@RequestMapping(path = "CartItem/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}

	@RequestMapping(path = "cartitems", method = RequestMethod.GET)
	public List<CartItem> index(HttpServletRequest req, HttpServletResponse res) {
		return cartItemService.index();
	}
	
	@RequestMapping(path = "cartitems/{itemid}", method = RequestMethod.POST)
	public CartItem addingToCart(HttpServletRequest req, HttpServletResponse res, @PathVariable("itemid") int itemId, @RequestBody CartItem addingCartItem) {
		return cartItemService.addToCart(addingCartItem);
	}

	@RequestMapping(path = "cartitems/{userid}", method = RequestMethod.GET)
	public List<CartItem> show(HttpServletRequest req, HttpServletResponse res, @PathVariable("userid") int userId) {
		return cartItemService.show(userId);
	}

	@RequestMapping(path = "cartitems/{id}", method = RequestMethod.PUT)
	public CartItem update(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") int id,
			@RequestBody CartItem CartItem) {
		return cartItemService.update(id, CartItem);
	}

	@RequestMapping(path = "cartitems/{id}", method = RequestMethod.DELETE)
	public void delete(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") int id,
			@RequestBody CartItem CartItem) {
		cartItemService.destroy(id);
	}
}
