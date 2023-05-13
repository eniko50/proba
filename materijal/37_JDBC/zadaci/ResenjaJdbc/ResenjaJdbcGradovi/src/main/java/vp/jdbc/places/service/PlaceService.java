package vp.jdbc.places.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.jdbc.places.data.PlaceRepository;
import vp.jdbc.places.model.Place;

@Component
public class PlaceService {
	// da bi place service radio, potrebni su mu podaci iz repozitorijuma
	@Autowired
	PlaceRepository placeRepository; 
	
	public Place findOne(int id) {
		return placeRepository.findOne(id);
	}

	public List<Place> findAll() {
		return placeRepository.findAll();
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
