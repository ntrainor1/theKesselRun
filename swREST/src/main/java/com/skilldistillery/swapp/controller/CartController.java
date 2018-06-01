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

import com.skilldistillery.swapp.Cart;
import com.skilldistillery.swapp.Profile;
import com.skilldistillery.swapp.service.CartService;

@CrossOrigin({ "*", "http://localhost:4200" })
@RestController
@RequestMapping("api")
public class CartController {
@Autowired
private CartService cartService;

@RequestMapping(path = "cart/ping", method=RequestMethod.GET)
public String ping() {
	return "pong";
}

@RequestMapping(path = "carts", method=RequestMethod.GET)
public List<Cart> index(HttpServletRequest req, HttpServletResponse res) {
	return cartService.index();
}

@RequestMapping(path = "carts/{id}", method=RequestMethod.GET)
public Cart show(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") int id) {
	return cartService.show(id);
}

@RequestMapping(path = "carts/{id}", method=RequestMethod.PUT)
public Cart update(HttpServletRequest req, HttpServletResponse res, @PathVariable("id") int id, @RequestBody Cart cart) {
	return cartService.update(id, cart);
}
}
