package vp.spring.mojnoviprojekat.sacasa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	@GetMapping("/api/cars")
	public String testMethod() {
		return "HELLO CARS";
	}
	
}
