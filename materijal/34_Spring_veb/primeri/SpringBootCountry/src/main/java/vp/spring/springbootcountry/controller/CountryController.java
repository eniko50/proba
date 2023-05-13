package vp.spring.springbootcountry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.springbootcountry.model.Country;
import vp.spring.springbootcountry.service.CountryService;

@RestController
public class CountryController {
	@Autowired
	CountryService countryService;
	
	// metoda ce biti pozvana za url /api/countries/test
	@RequestMapping(value="/test") 
	public String test() {
		return "Odgovor";
	}
	
	// metoda ce biti pozvana kada se uputi GET zahtev na api/countries
	@RequestMapping(value="api/countries", method = RequestMethod.GET) 
	public String getAllCountries() {
		List<Country> countries = countryService.findAll();
		
		StringBuffer sb = new StringBuffer();
		for (Country c: countries) {
			sb.append(c).append("\n"); 
		}
		
		return sb.toString();
	}
	
	@RequestMapping(value="pages/countries", method = RequestMethod.GET) 
	public String getCountriesHtml() {
		List<Country> countries = countryService.findAll();
		
		StringBuffer sb = new StringBuffer();
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<td>");
		sb.append("Naziv");
		sb.append("</td>");
		sb.append("<td>");
		sb.append("Broj stanovnika");
		sb.append("</td>");
		sb.append("</tr>");
		
		for (Country c: countries) {
			sb.append("<tr>");
			sb.append("<td>");
			sb.append(c.getName());
			sb.append("</td>");
			sb.append("<td>");
			sb.append(c.getPopulation());
			sb.append("</td>");
			sb.append("</tr>"); 
		}
		
		return sb.toString();
	}
	
	// ako trazimo drzavu sa id 5, metoda ce biti pozvana kada se uputi GET zahtev na api/countries/5
	@RequestMapping(value="api/countries/{id}", method = RequestMethod.GET) 
	public String getCountry(@PathVariable int id) {
		Country country = countryService.findOne(id);
		
		return country.toString();
	}
	
	// ako trazimo drzave koje sadrze "Srb", 
	// metoda ce biti pozvana kada se uputi GET zahtev na api/countries/search?name=Srb
	@RequestMapping(value="api/countries/search", method = RequestMethod.GET) 
	public String getCountriesByName(@RequestParam String name) {
		List<Country> countries = countryService.findByName(name);
		
		StringBuffer sb = new StringBuffer();
		for (Country c: countries) {
			sb.append(c).append("\n"); 
		}
		
		return sb.toString();
	}
}
