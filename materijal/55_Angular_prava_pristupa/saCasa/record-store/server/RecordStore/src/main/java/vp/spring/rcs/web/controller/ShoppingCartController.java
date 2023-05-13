package vp.spring.rcs.web.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Record;
import vp.spring.rcs.model.ShoppingCart;
import vp.spring.rcs.service.ShoppingCartService;

@RestController
@RequestMapping(value = "/api/shoppingCart")
public class ShoppingCartController {
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<ShoppingCart> getShoppingCart() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		ShoppingCart sc = shoppingCartService.findByUsername(authentication.getName());
		return new ResponseEntity<>(sc, HttpStatus.OK); 
	}

	@RequestMapping(value="/records", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ShoppingCart> addRecord(@RequestBody Record record) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		ShoppingCart sc = shoppingCartService.findByUsername(authentication.getName());
		if(sc==null) {
			sc = new ShoppingCart(authentication.getName(), new HashSet<>());
		}
		if (!sc.getRecords().contains(record)) {
			sc.getRecords().add(record);
			sc = shoppingCartService.save(sc);			
		}
		return new ResponseEntity<>(sc, HttpStatus.CREATED);
	}

}
