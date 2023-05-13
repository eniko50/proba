package vp.jdbc.places.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vp.jdbc.places.model.Country;
import vp.jdbc.places.service.CountryService;

@RestController
public class CountryController {
	@Autowired
	CountryService countryService;

	// server vraca odgovor u formi JSON ili XML dokumenta zavisno od Accept polja u zaglavlju zahteva
	// default je JSON - vraca JSON ako klijent nije specificirao sta prihvata
	@RequestMapping(value = "api/countries", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Country>> getAllCountries() {
		List<Country> countries = countryService.findAll();

		return new ResponseEntity<>(countries, HttpStatus.OK); // automatska
																// serijalizacija
																// liste drzava
	}

	@RequestMapping(value = "api/countries/{id}", method = RequestMethod.GET)
	public ResponseEntity<Country> getCountry(@PathVariable int id) {
		Country country = countryService.findOne(id);

		return new ResponseEntity<>(country, HttpStatus.OK);
	}

	// server ocekuje JSON objekat da primi u telu zahteva
	@RequestMapping(value = "api/countries", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Country> create(@RequestBody Country country) {
		// country je preuzet iz zahteva
		// automatski se deserijalizuju podaci iz JSON u objekat klase Country

		Country retVal = countryService.save(country);

		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}

	@RequestMapping(value = "api/countries/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Country> update(@PathVariable int id,
			@RequestBody Country country) {
		country.setId(id);
		// servis ce pronaci drzavu sa tim id-om i izvrsiti promenu podataka
		Country retVal = countryService.save(country);

		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

	@RequestMapping(value = "api/countries/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable int id) {
		Country country = countryService.findOne(id);
		if (country != null) {
			countryService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// parametar se mora naznaciti i u params ako dve metode sa istim URL-om
	// imaju razlicite parametre
	// isti URL ali sa razlicitim parametrima (tj. bez parametara) ima metoda
	// getAllCountries
	@RequestMapping(value = "api/countries", method = RequestMethod.GET, params = "name")
	public ResponseEntity<List<Country>> getCountriesByName(
			@RequestParam String name) {
		List<Country> countries = countryService.findByName(name);

		return new ResponseEntity<>(countries, HttpStatus.OK);
	}

	@RequestMapping(value = "api/countries", method = RequestMethod.GET, params = "population")
	public ResponseEntity<List<Country>> getCountriesByPopulation(
			@RequestParam int population) {
		List<Country> countries = countryService.findByPopulation(population);

		return new ResponseEntity<>(countries, HttpStatus.OK);
	}

	@RequestMapping(value = "api/countries", method = RequestMethod.GET, params = {
			"name", "population" })
	public ResponseEntity<List<Country>> getCountriesByNameAndPopulation(
			@RequestParam String name, @RequestParam int population) {
		List<Country> countries = countryService.findByNameOrPopulation(name,
				population);

		return new ResponseEntity<>(countries, HttpStatus.OK);
	}
}
