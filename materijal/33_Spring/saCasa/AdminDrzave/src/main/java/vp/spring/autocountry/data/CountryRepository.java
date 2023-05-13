package vp.spring.autocountry.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import vp.spring.autocountry.aspect.IsAdmin;
import vp.spring.autocountry.aspect.LogEvent;
import vp.spring.autocountry.model.Country;

/**
 * Klasa je zaduzena za evidenciju podataka o drzavama
 * Zbog jednostavnosti, podaci se skladiste u radnoj memoriji 
 * bez perzistiranja u bazi podataka
 * 
 * @author Goran
 *
 */
@Component
public class CountryRepository {
	private List<Country> countries = new ArrayList<Country>();
	
	public List<Country> getCountries() {
		return countries;
	}

	// pri instanciranju se popunjava in-memory evidencija test podacima
	public CountryRepository() {
		countries.add(new Country(1, "Serbia", 7098000));
		countries.add(new Country(2, "France", 66810000));
		countries.add(new Country(3, "Italy", 60800000));
	}
	
	@LogEvent // nad ovako anotiranim metodama ce biti izvrsen odredjeni aspekt
	public List<Country> findAll() {
		return countries;
	}
	
	@LogEvent 
	public Country findOne(int id) {
		for (Country country: countries) {
			if (country.getId() == id) {
				return country;
			}
		}
		return null;
	}
	
	public void save(Country country) {
		// save radi i snimanje i izmenu
		// ako prosledjeni entitet vec postoji u listi, onda je rec o izmeni
		Country existingCountry = findOne(country.getId());
		if (existingCountry == null) {
			countries.add(country);
		} else { // ako drzava vec postoji u repozitorijumu, save radi izmenu podataka te drzave
			existingCountry.setName(country.getName());
			existingCountry.setPopulation(country.getPopulation());
		}
	}
	
	// brise drzavu sa zadatim id-om
	@IsAdmin
	public void delete(int id) {		
		Iterator<Country> it = countries.iterator();
		while (it.hasNext()) {
			if (it.next().getId() == id) {
				it.remove();
				return;
			}
		}			
	}
	
	// trazi drzave sa naznacenom populacijom
	public List<Country> findByPopulation(int population) {
		List<Country> retVal = new ArrayList<Country>();
		for (Country country: countries) {
			if (country.getPopulation() == population) {
				retVal.add(country);
			}
		}
		return retVal;
	}
	
	// trazi drzave ciji naziv sadrzi prosledjenu rec
	public List<Country> findByNameContains(String name) {
		List<Country> retVal = new ArrayList<Country>();
		for (Country country: countries) {
			if (country.getName().contains(name)) {
				retVal.add(country);
			}
		}
		return retVal;
	}
	
	// trazi drzave ciji naziv sadrzi odredjenu rec ili imaju populaciju vecu od zadate
	public List<Country> findByNameContainsOrPopulationGreaterThan(String name, int population) {
		List<Country> retVal = new ArrayList<Country>();
		for (Country country: countries) {
			if (country.getName().contains(name) || country.getPopulation() > population) {
				retVal.add(country);
			}
		}
		return retVal;
	}
}
