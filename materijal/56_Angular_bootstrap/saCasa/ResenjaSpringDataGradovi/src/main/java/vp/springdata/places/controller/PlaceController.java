package vp.springdata.places.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vp.springdata.places.dto.PlaceDTO;
import vp.springdata.places.model.Country;
import vp.springdata.places.model.Place;
import vp.springdata.places.service.PlaceService;

@RestController
public class PlaceController {
	@Autowired
	PlaceService placeService;

	@RequestMapping(value = "api/places", method = RequestMethod.GET)
	public ResponseEntity<List<PlaceDTO>> getPlacesPage(Pageable page) {
		Page<Place> places = placeService.findAll(page);
		
		List<PlaceDTO> retVal = new ArrayList<>();
		for (Place place: places) {
			retVal.add(new PlaceDTO(place));
		}

		return new ResponseEntity<>(retVal, HttpStatus.OK); 
	}

	@RequestMapping(value = "api/places/{id}", method = RequestMethod.GET)
	public ResponseEntity<PlaceDTO> getPlace(@PathVariable Long id) {
		Place place = placeService.findOne(id);
		
		if (place != null) {
			PlaceDTO placeDTO = new PlaceDTO(place);
			return new ResponseEntity<>(placeDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "api/places", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PlaceDTO> create(@RequestBody PlaceDTO placeDTO) {
		Place place = new Place();
		place.setName(placeDTO.getName());
		place.setZipCode(placeDTO.getZipCode());
		place.setCountry(new Country(placeDTO.getCountry().getId(), null,0)); // samo nam je id drzave bitan
		
		place = placeService.save(place);

		return new ResponseEntity<>(new PlaceDTO(place), HttpStatus.CREATED);
	}

	@RequestMapping(value = "api/places/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PlaceDTO> update(@PathVariable Long id,
			@RequestBody PlaceDTO placeDTO) {
		
		Place place = placeService.findOne(id);
		if (place == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		place.setId(id);
		place.setName(placeDTO.getName());
		place.setZipCode(placeDTO.getZipCode());
		place.setCountry(new Country(placeDTO.getCountry().getId(),
				placeDTO.getCountry().getName(), placeDTO.getCountry().getPopulation()));
		
		place = placeService.save(place);

		return new ResponseEntity<>(new PlaceDTO(place), HttpStatus.OK);
	}

	@RequestMapping(value = "api/places/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Place place = placeService.findOne(id);
		if (place != null) {
			placeService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "api/places", method = RequestMethod.GET, params = "name")
	public ResponseEntity<List<PlaceDTO>> getPlacesByName(
			@RequestParam String name) {
		List<Place> places = placeService.findByName(name);
		List<PlaceDTO> retVal = new ArrayList<>();
		for (Place place: places) {
			retVal.add(new PlaceDTO(place));
		}
		return new ResponseEntity<>(retVal, HttpStatus.OK); 
	}

	@RequestMapping(value = "api/countries/{countryId}/places", method = RequestMethod.GET)
	public ResponseEntity<List<PlaceDTO>> getCountryPlaces(
			@PathVariable Long countryId) {
		List<Place> places = placeService.findByCountryId(countryId);
		List<PlaceDTO> retVal = new ArrayList<>();
		for (Place place: places) {
			retVal.add(new PlaceDTO(place));
		}

		return new ResponseEntity<>(retVal, HttpStatus.OK); 
	}
	
}
