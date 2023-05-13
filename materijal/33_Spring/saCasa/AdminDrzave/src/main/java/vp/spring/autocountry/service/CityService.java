package vp.spring.autocountry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vp.spring.autocountry.data.CityRepository;
import vp.spring.autocountry.data.CountryRepository;
import vp.spring.autocountry.model.City;
import vp.spring.autocountry.model.Country;

@Service
public class CityService {
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	public List<City> findByCountryId(int countryId) {
		return cityRepository.findByCountryId(countryId);
	}
	
	public List<City> findAll() {
		return cityRepository.findAll();
	}

	public void save(int id, String name, String zipCode, int countryId) {
		Country country = countryRepository.findOne(countryId);
		if (country == null) {
			System.out.println("Nema drzave sa id-em: " + countryId);
			return;
		}
		
		City newCity = new City(id, name, zipCode, country);
		cityRepository.save(newCity);
	}
}
