package vp.spring.rcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.ShoppingCartRepository;
import vp.spring.rcs.model.ShoppingCart;

@Component
public class ShoppingCartService {

	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	public ShoppingCart findByUsername(String username) {
		return shoppingCartRepository.findByUsername(username);
	}
	
	public ShoppingCart save(ShoppingCart shoppingCart) {
		return shoppingCartRepository.save(shoppingCart);
	}
}
