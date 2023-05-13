package vp.spring.JdbcCountry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.JdbcCountry.data.CountryRepository;
import vp.spring.JdbcCountry.data.PlaceRepository;
import vp.spring.JdbcCountry.model.Country;
import vp.spring.JdbcCountry.model.Place;

@Component
public class PlaceService {
	// da bi place service radio, potrebni su mu podaci iz repozitorijuma
	@Autowired
	PlaceRepository placeRepository; 
	
	@Autowired
	CountryRepository countryRepository;
	
	public Place findOne(int id) {
		return placeRepository.findOne(id);
	}

	public List<Place> findAll() {
		return placeRepository.findAll();
	}
	
	public Place create(Place place, int countryId) {
		Country country = countryRepository.findOne(countryId);
		if (country == null) {
			return null;
		}
		
		place.setCountry(country);
		
		return placeRepository.save(place);
	}
	
	public Place save(Place place) {
		return placeRepository.save(place);
	}

	public void remove(int id) {
		placeRepository.delete(id);
	}
	
	public List<Place> findByName(String name) {
		return placeRepository.findByNameContains(name);
	}
	
	public List<Place> findByCountryId(int id) {
		return placeRepository.findByCountryId(id);
	}
}
