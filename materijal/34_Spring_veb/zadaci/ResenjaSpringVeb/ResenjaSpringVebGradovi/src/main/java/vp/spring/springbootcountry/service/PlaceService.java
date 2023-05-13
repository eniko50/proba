package vp.spring.springbootcountry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import vp.spring.springbootcountry.data.PlaceRepository;
import vp.spring.springbootcountry.model.Place;

@Service
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
	
	public List<Place> findByName(String name) {
		return placeRepository.findByNameContains(name);
	}
	
}
