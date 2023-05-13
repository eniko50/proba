package vp.spring.JdbcCountry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.JdbcCountry.model.Place;
import vp.spring.JdbcCountry.service.PlaceService;

@RestController
public class PlaceController {
	@Autowired
	PlaceService placeService;

	@RequestMapping(value = "api/places", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Place>> getAllPlaces() {
		List<Place> places = placeService.findAll();

		return new ResponseEntity<>(places, HttpStatus.OK); 
	}

	@RequestMapping(value = "api/places/{id}", method = RequestMethod.GET)
	public ResponseEntity<Place> getPlace(@PathVariable int id) {
		Place place = placeService.findOne(id);

		return new ResponseEntity<>(place, HttpStatus.OK);
	}

	@PostMapping("api/countries/{countryId}/places")
	public ResponseEntity<Place> create(@PathVariable int countryId,
									   @RequestBody Place place) {
		Place retVal = placeService.create(place, countryId);

		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}

	@RequestMapping(value = "api/places/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Place> update(@PathVariable int id,
			@RequestBody Place place) {
		place.setId(id);
		// servis ce pronaci drzavu sa tim id-om i izvrsiti promenu podataka
		Place retVal = placeService.save(place);

		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

	@RequestMapping(value = "api/places/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable int id) {
		Place place = placeService.findOne(id);
		if (place != null) {
			placeService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "api/places", method = RequestMethod.GET, params = "name")
	public ResponseEntity<List<Place>> getPlacesByName(
			@RequestParam String name) {
		List<Place> places = placeService.findByName(name);

		return new ResponseEntity<>(places, HttpStatus.OK);
	}

	@RequestMapping(value = "api/countries/{countryId}/places", method = RequestMethod.GET)
	public ResponseEntity<List<Place>> getCountryPlaces(
			@PathVariable int countryId) {
		List<Place> places = placeService.findByCountryId(countryId);

		return new ResponseEntity<>(places, HttpStatus.OK);
	}
	
}
