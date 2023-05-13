package vp.spring.springbootcountry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vp.spring.springbootcountry.data.CityRepository;
import vp.spring.springbootcountry.model.City;

@Service // ili @Component - isti djavo
public class CityService {

	@Autowired
	private CityRepository cityRepository;
	
	public List<City> findAll() {
		return cityRepository.findAll();
	}
	
	public City findOne(int id) {
		return cityRepository.findOne(id);
	}

	public List<City> findByCountryId(int countryId) {
		return cityRepository.findByCountryId(countryId);
	}
}
