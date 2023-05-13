package vp.spring.Rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.Rest.model.Place;
import vp.spring.Rest.service.PlaceService;

@RestController
public class PlaceController {

	@Autowired
	private PlaceService placeService;
	
	@GetMapping("/api/cities")
	public ResponseEntity<List<Place>> getAll() {
		List<Place> cities = placeService.findAll();
		
		return new ResponseEntity<>(cities, HttpStatus.OK);
	}
	
	@DeleteMapping("/api/cities/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		Place place = placeService.findOne(id);
		
		if (place == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		placeService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}











