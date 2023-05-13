package vp.spring.country.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.country.data.PlaceRepository;
import vp.spring.country.model.Place;

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
	
	public void save(Place place) {
		placeRepository.save(place);
	}

	public void remove(int id) {
		placeRepository.delete(id);
	}
	
}
