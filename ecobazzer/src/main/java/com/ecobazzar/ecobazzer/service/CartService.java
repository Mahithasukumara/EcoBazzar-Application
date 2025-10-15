package com.ecobazzar.ecobazzer.service;

import com.ecobazzar.ecobazzer.repository.CartRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecobazzar.ecobazzer.model.CartItem;
@Service
public class CartService {
	private final CartRepository cartrepo;
	public CartService(CartRepository cartrepo) {
		this.cartrepo=cartrepo;
	}
	public CartItem addToCart(CartItem cartitem) {
		return cartrepo.save(cartitem);
	}
	public String delFromCart(Long id) {
		 cartrepo.deleteById(id);
		 return "Item deleted from cart";
	}
	public List<CartItem> getCartItemsByUserId(Long userId){
		return cartrepo.findByUserId(userId);
	}

}
