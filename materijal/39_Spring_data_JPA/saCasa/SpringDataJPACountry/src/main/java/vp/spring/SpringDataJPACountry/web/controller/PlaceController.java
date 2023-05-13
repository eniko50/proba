package vp.spring.SpringDataJPACountry.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.SpringDataJPACountry.model.Country;
import vp.spring.SpringDataJPACountry.model.Place;
import vp.spring.SpringDataJPACountry.service.CountryService;
import vp.spring.SpringDataJPACountry.service.PlaceService;
import vp.spring.SpringDataJPACountry.web.dto.CountryDTO;
import vp.spring.SpringDataJPACountry.web.dto.CreatePlaceDTO;
import vp.spring.SpringDataJPACountry.web.dto.PlaceDTO;

@RestController
public class PlaceController {

	@Autowired
	private PlaceService placeService;
	
	@Autowired
	private CountryService countryService; 

	@GetMapping("/api/places")
	public ResponseEntity<Page<PlaceDTO>> findAll(Pageable page) {
		Page<Place> places = placeService.findAll(page);
		List<PlaceDTO> dtos = convertPlacesToDtos(places.getContent());

		Page<PlaceDTO> dtoPage = 
				new PageImpl<>(dtos, page, places.getTotalElements());
		
		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
	}
	
	@PostMapping("/api/places")
	public ResponseEntity<PlaceDTO> create(
			@RequestBody CreatePlaceDTO dto) {
		
		Country country = countryService.findOne(dto.getCountryId());
		if (country == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Place place = new Place();
		place.setCountry(country);
		place.setName(dto.getName());
		place.setZipCode(dto.getZipCode());
		
		place = placeService.save(place);
		
		PlaceDTO placeDto = new PlaceDTO(place);
		placeDto.setCountry(new CountryDTO(country));
		
		return new ResponseEntity<>(placeDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/api/places/{id}")
	public ResponseEntity<PlaceDTO> update(@PathVariable long id,
			@RequestBody PlaceDTO updateDto) {
		Place place = placeService.findOne(id);
		if (place == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
		place.setName(updateDto.getName());
		place.setZipCode(updateDto.getZipCode());
		
		place = placeService.save(place);
		
		PlaceDTO placeDto = new PlaceDTO(place);
		placeDto.setCountry(new CountryDTO(place.getCountry()));
		
		return new ResponseEntity<>(placeDto, HttpStatus.OK);
	}

	private List<PlaceDTO> convertPlacesToDtos(List<Place> places) {
		List<PlaceDTO> dtos = new ArrayList<>();
		for (Place place : places) {
			PlaceDTO dto = new PlaceDTO(place);
			CountryDTO countryDTO = new CountryDTO(place.getCountry());
			dto.setCountry(countryDTO);
			
			dtos.add(dto);
		}

		return dtos;
	}

}
