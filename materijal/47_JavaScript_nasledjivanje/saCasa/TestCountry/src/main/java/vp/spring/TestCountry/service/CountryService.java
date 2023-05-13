package vp.spring.TestCountry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import vp.spring.TestCountry.data.CountryRepository;
import vp.spring.TestCountry.model.Country;
import vp.spring.TestCountry.web.controller.exception.ForbiddenException;
import vp.spring.TestCountry.web.controller.exception.NotFoundException;


@Component
public class CountryService {
	// da bi country service radio, potrebni su mu podaci iz repozitorijuma
	@Autowired
	CountryRepository countryRepository;

	public Country findOne(Long id) {
		return countryRepository.findById(id).orElseThrow(NotFoundException::new);
	}

	public List<Country> findAll() {
		throw new ForbiddenException();
	}
	
	public Page<Country> findAll(Pageable page) {
		throw new ForbiddenException();
	}

	public Country save(Country country) {
		return countryRepository.save(country);
	}

	public void remove(Long id) {
		countryRepository.deleteById(id);
	}

	public List<Country> findByName(String name) {
		return countryRepository.findByNameContains(name);
	}

	public List<Country> findByPopulation(int population) {
		return countryRepository.findByPopulation(population);
	}

	public List<Country> findByNameOrPopulation(String name, int population) {
		return countryRepository.findByNameContainsOrPopulationGreaterThan(
				name, population);
	}

	// metode klasifikuje drzavu na osnovu broja stanovnika
	// vraca oznaku grupe u koju je drzava klasifikovana prema sledecem pravilu:
	// 1 - drzave koje imaju vise od 10 miliona stanovnika
	// 2 - drzave koje imaju izmedju 1 i 10 miliona stanovnika
	// 3 - drzave koje imaju manje od milion stanovnika
	public int classifyCountry(Long countryId) {
		Country country = countryRepository.findById(countryId).get();
		if (country.getPopulation() > 10000000) {
			return 1;
		} else if (country.getPopulation() > 1000000) {
			return 2;
		} else {
			return 3;
		}
	}
}
