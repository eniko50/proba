package vp.spring.springbootcountry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.springbootcountry.model.City;
import vp.spring.springbootcountry.service.CityService;

@RestController
public class CityController {
	
	@Autowired
	private CityService cityService;

	@RequestMapping(value="/api/cities", method=RequestMethod.GET)
//	@GetMapping("/api/cities")
	public String findAll() {
		List<City> cities = cityService.findAll();
		
		return formatCities(cities);
	}

	@GetMapping("/api/cities/{id}")
	public String findOne(@PathVariable int id) {
		City city = cityService.findOne(id);

		return city.toString();
	}
	
	@GetMapping(value="/api/cities", params="countryId")
	public String findByCountry(@RequestParam int countryId) {
		List<City> cities = cityService.findByCountryId(countryId);
		
		return formatCities(cities);
	}
	
	@GetMapping(value="/api/cities", params= {"countryId", "name"})
	public String findByCountryIdAndNameContains(
			@RequestParam int countryId,
			@RequestParam String name) {
		return null;
	}
	
	private String formatCities(List<City> cities) {
		StringBuffer buffer = new StringBuffer();
		for (City city : cities) {
			buffer.append(city.toString());
			buffer.append("<br />");
		}
		
		return buffer.toString();
	}
}
