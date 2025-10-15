package com.ecobazzar.ecobazzer.controller;
import com.ecobazzar.ecobazzer.service.CartService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecobazzar.ecobazzer.model.CartItem;

@RestController
@RequestMapping("api/cart")
public class CartController {
	private final CartService cartservice;
	public CartController(CartService cartservice) {
		this.cartservice=cartservice;
	}
	@PostMapping
	public CartItem addToCart(@RequestBody CartItem cartitem) {
		return cartservice.addToCart(cartitem);
		
	}
	@GetMapping("/{userId}")
	public List<CartItem>getCartItemsByUserId(@PathVariable Long userId) {
		return cartservice.getCartItemsByUserId(userId);
		
	}
	@DeleteMapping("/{id}")
	public String delFromCart(@PathVariable Long id) {
		 cartservice.delFromCart(id);
		 return "Item deleted from cart";
		
	}
	
	

}
