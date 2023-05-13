package vp.spring.TestCountry.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import vp.spring.TestCountry.model.Country;


/**
 * Klasa je zaduzena za evidenciju podataka o drzavama. Podaci se perzistiraju u
 * relacionoj bazi podataka 
 * 
 * @author Goran
 *
 */
@Component
public interface CountryRepository extends JpaRepository<Country, Long> {

	// preuzima drzave sa naznacenom populacijom
	public List<Country> findByPopulation(int population);
	// preuzima drzave ciji naziv sadrzi prosledjenu rec
	public List<Country> findByNameContains(String name);
	// preuzima drzave ciji naziv sadrzi odredjenu rec ili imaju populaciju vecu od zadate
	public List<Country> findByNameContainsOrPopulationGreaterThan(String name, int population);
}
