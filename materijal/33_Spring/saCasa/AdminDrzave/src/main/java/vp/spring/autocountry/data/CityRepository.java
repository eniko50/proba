package vp.spring.autocountry.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.autocountry.model.City;
import vp.spring.autocountry.model.Country;

@Component
public class CityRepository {
	
	private List<City> cities = new ArrayList<>();
	
	CountryRepository countryRepository;

	@Autowired
	public CityRepository(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;

		Country serbia = countryRepository.findOne(1);
		cities.add(new City(1, "Novi Sad", "21000", serbia));
		cities.add(new City(2, "Subotica", "24000", serbia));
		cities.add(new City(3, "Krusevac", "32000", serbia));
		
		Country france = countryRepository.findOne(2);
		cities.add(new City(4, "Lion", "baget", france));
		cities.add(new City(5, "Paris", "kroasan", france));
		
		Country italy = countryRepository.findOne(3);
		cities.add(new City(6, "Rome", "spaghetti", italy));
		cities.add(new City(7, "Milan", "oliva", italy));
	}
	
	public List<City> findAll() {
		return cities;
	}
	
	public List<City> findByCountryId(int countryId) {
		List<City> foundCities = new ArrayList<>();
		for (City city : cities) {
			if (city.getCountry().getId() == countryId) {
				foundCities.add(city);
			}
		}
		
		return foundCities;
	}
	
	public void save(City city) {
		this.cities.add(city);
	}
}



