package vp.spring.JpaCountry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.JpaCountry.model.Place;
import vp.spring.JpaCountry.service.PlaceService;

@RestController
public class PlaceController {
	
	@Autowired
	PlaceService placeService;
	
	@GetMapping("/api/places")
	public ResponseEntity<List<Place>> findAll() {
		List<Place> places = placeService.findAll();
		
		return new ResponseEntity<>(places, HttpStatus.OK);
	}
	
	@GetMapping("/api/places/{id}")
	public ResponseEntity<Place> findOne(@PathVariable long id) {
		Place place = placeService.findOne(id);
		
		if (place == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(place, HttpStatus.OK);
		}
	}
	
	@GetMapping("/api/countries/{countryId}/places")
	public ResponseEntity<List<Place>> findByCountry(@PathVariable long countryId) {
		List<Place> places = placeService.findByCountryId(countryId);
		
		return new ResponseEntity<>(places, HttpStatus.OK);
	}
	
	@PostMapping("/api/places")
	public ResponseEntity<Place> addPlace(@RequestBody Place place) {
		place.setId(null);
		Place savedPlace = placeService.save(place);
		
		return new ResponseEntity<>(savedPlace, HttpStatus.CREATED);
	}

}













