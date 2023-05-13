package vp.springdata.places.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import vp.springdata.places.data.PlaceRepository;
import vp.springdata.places.model.Place;

@Component
public class PlaceService {
	// da bi place service radio, potrebni su mu podaci iz repozitorijuma
	@Autowired
	PlaceRepository placeRepository; 
	
	public Place findOne(Long id) {
		return placeRepository.findById(id).get();
	}

	public List<Place> findAll() {
		return placeRepository.findAll();
	}
	
	public Page<Place> findAll(Pageable page) {
		return placeRepository.findAll(page);
	}
	
	public Place save(Place place) {
		return placeRepository.save(place);
	}

	public void remove(Long id) {
		placeRepository.deleteById(id);
	}
	
	public List<Place> findByName(String name) {
		return placeRepository.findByNameContains(name);
	}
	
	public List<Place> findByCountryId(Long id) {
		return placeRepository.findByCountryId(id);
	}
}
