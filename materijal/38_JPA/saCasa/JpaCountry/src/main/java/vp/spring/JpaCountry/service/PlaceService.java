package vp.spring.JpaCountry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.JpaCountry.data.PlaceRepository;
import vp.spring.JpaCountry.model.Place;

@Component
public class PlaceService {

	@Autowired
	PlaceRepository placeRepository;
	
	public List<Place> findAll() {
		return placeRepository.findAll();
	}
	
	public Place findOne(Long id) {
		return placeRepository.findOne(id);
	}

	public List<Place> findByCountryId(long countryId) {
		return placeRepository.findByCountryId(countryId);
	}

	public Place save(Place place) {
		return placeRepository.save(place);
	}
}
