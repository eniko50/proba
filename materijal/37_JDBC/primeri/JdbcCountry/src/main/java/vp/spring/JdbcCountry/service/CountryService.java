package vp.spring.JdbcCountry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.JdbcCountry.data.CountryRepository;
import vp.spring.JdbcCountry.model.Country;

@Component
public class CountryService {
	// da bi country service radio, potrebni su mu podaci iz repozitorijuma
	@Autowired
	CountryRepository countryRepository;

	public Country findOne(int id) {
		return countryRepository.findOne(id);
	}

	public List<Country> findAll() {
		return countryRepository.findAll();
	}

	public Country save(Country country) {
		return countryRepository.save(country);
	}

	public void remove(int id) {
		countryRepository.delete(id);
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
	public int classifyCountry(int countryId) {
		Country country = countryRepository.findOne(countryId);
		if (country.getPopulation() > 10000000) {
			return 1;
		} else if (country.getPopulation() > 1000000) {
			return 2;
		} else {
			return 3;
		}
	}
}
