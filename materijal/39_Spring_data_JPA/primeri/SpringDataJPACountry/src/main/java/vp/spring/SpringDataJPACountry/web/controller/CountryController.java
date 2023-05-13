package vp.spring.SpringDataJPACountry.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.SpringDataJPACountry.model.Place;
import vp.spring.SpringDataJPACountry.model.Country;
import vp.spring.SpringDataJPACountry.service.CountryService;
import vp.spring.SpringDataJPACountry.web.dto.PlaceDTO;
import vp.spring.SpringDataJPACountry.web.dto.CountryDTO;


@RestController
public class CountryController {
	@Autowired
	CountryService countryService;

	@RequestMapping(value = "api/countries", method = RequestMethod.GET)
	public ResponseEntity<List<CountryDTO>> getCountriesPage(Pageable page) {
		// page objekat sadrzi podatke o paginaciji i sortiranju
		// objekat je kreran od strane Spring kontejnera na osnovu parametara
		// "page", "size" i "sort" u URL-u zahteva 
		Page<Country> countries = countryService.findAll(page);
		
		// mozemo informacije o stranici da ubacimo u zaglavlje odgovora
		HttpHeaders headers = new HttpHeaders();
		long countriesTotal = countries.getTotalElements();
		headers.add("X-Total-Count", String.valueOf(countriesTotal));
		
		// prebacivanje rezultata u DTO objekte
		List<CountryDTO> retVal = convertCountriesToDTOs(countries.getContent());
		
		return new ResponseEntity<>(retVal, headers, HttpStatus.OK); 
	}

	@RequestMapping(value = "api/countries/{id}", method = RequestMethod.GET)
	public ResponseEntity<CountryDTO> getCountry(@PathVariable Long id) {
		Country country = countryService.findOne(id);
		
		if (country != null) {
			CountryDTO countryDTO = new CountryDTO(country);
			// popunjavanje i kolekcije gradova u DTO objektu
			for (Place city: country.getPlaces()) {
				countryDTO.getPlaces().add(new PlaceDTO(city));
			}			
			return new ResponseEntity<>(countryDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "api/countries", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CountryDTO> create(@RequestBody CountryDTO countryDTO) {
		// prebacivanje iz dobijenog DTO objekta u JPA objekat
		Country country = new Country();
		country.setName(countryDTO.getName());
		country.setPopulation(countryDTO.getPopulation());
		
		country = countryService.save(country);

		return new ResponseEntity<>(new CountryDTO(country), HttpStatus.CREATED);
	}

	@RequestMapping(value = "api/countries/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CountryDTO> update(@PathVariable Long id,
			@RequestBody CountryDTO countryDTO) {
		Country country = countryService.findOne(id);
		if (country == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		country.setId(id);
		country.setName(countryDTO.getName());
		country.setPopulation(countryDTO.getPopulation());
		
		country = countryService.save(country);

		return new ResponseEntity<>(new CountryDTO(country), HttpStatus.OK);
	}

	@RequestMapping(value = "api/countries/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
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
	// getCountriesPage
	@RequestMapping(value = "api/countries", method = RequestMethod.GET, params = "name")
	public ResponseEntity<List<CountryDTO>> getCountriesByName(
			@RequestParam String name) {
		List<Country> countries = countryService.findByName(name);		
		List<CountryDTO> retVal = convertCountriesToDTOs(countries);
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

	@RequestMapping(value = "api/countries", method = RequestMethod.GET, params = "population")
	public ResponseEntity<List<CountryDTO>> getCountriesByPopulation(
			@RequestParam int population) {
		List<Country> countries = countryService.findByPopulation(population);
		List<CountryDTO> retVal = convertCountriesToDTOs(countries);
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

	@RequestMapping(value = "api/countries", method = RequestMethod.GET, params = {
			"name", "population" })
	public ResponseEntity<List<CountryDTO>> getCountriesByNameAndPopulation(
			@RequestParam String name, @RequestParam int population) {
		List<Country> countries = countryService.findByNameOrPopulation(name,
				population);
		List<CountryDTO> retVal = convertCountriesToDTOs(countries);
		return new ResponseEntity<>(retVal, HttpStatus.OK);	
	}
	
	private List<CountryDTO> convertCountriesToDTOs(List<Country> countries) {
		List<CountryDTO> retVal = new ArrayList<>();
		for (Country country: countries) {
			CountryDTO countryDTO = new CountryDTO(country); 
			// popunjavanje i kolekcije gradova u DTO objektu
			for (Place city: country.getPlaces()) {
				countryDTO.getPlaces().add(new PlaceDTO(city));
			}
			retVal.add(countryDTO);
		}
		return retVal;
	}
}
