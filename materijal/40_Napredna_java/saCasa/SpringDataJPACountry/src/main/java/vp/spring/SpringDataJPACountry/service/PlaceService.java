package vp.spring.SpringDataJPACountry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import vp.spring.SpringDataJPACountry.data.PlaceRepository;
import vp.spring.SpringDataJPACountry.model.Place;

@Component
public class PlaceService {

	@Autowired
	private PlaceRepository placeRepository;
	
	public Page<Place> findAll(Pageable page) {
		return placeRepository.findAll(page);
	}
	
	public Place save(Place place) {
		return placeRepository.save(place);
	}

	public Place findOne(long id) {
		return placeRepository.findById(id).get();
	}
	
}
