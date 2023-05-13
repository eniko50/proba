package vp.spring.JpaCountry.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import vp.spring.JpaCountry.model.Country;


/**
 * Klasa je zaduzena za evidenciju podataka o drzavama. Podaci se perzistiraju u
 * relacionoj bazi podataka 
 * 
 * @author Goran
 *
 */
@Component
@Transactional // izvrsice metode u transakciji (kreirace novu transakciju ako poziv metode nije u transakciji)
public class CountryRepository {

	@PersistenceContext
	EntityManager em;

	public List<Country> findAll() {
		Query q = em.createQuery("SELECT c FROM Country c");

		return q.getResultList();
	}

	public Country findOne(Long id) {
		return em.find(Country.class, id);
	}

	public Country save(Country country) {
		// save radi i snimanje i izmenu
		// ako prosledjeni entitet ima validan id, smatra se da je rec o izmeni
		
		if (country.getId() != null) {
			return em.merge(country);	
		} else {
			em.persist(country);
			return country;		
		}
		
	}
	
	// brise drzavu sa zadatim id-om
	public void delete(Long id) {
		em.remove(findOne(id));
	}

	// trazi drzave sa naznacenom populacijom
	public List<Country> findByPopulation(int population) {
		Query q = em.createQuery("SELECT c FROM Country c WHERE population = :population");
		q.setParameter("population", population); 
		return q.getResultList();
	}

	// trazi drzave ciji naziv sadrzi prosledjenu rec
	public List<Country> findByNameContains(String name) {
		Query q = em.createQuery("SELECT c FROM Country c WHERE name LIKE :name");
		q.setParameter("name", "%" + name + "%"); 
		return q.getResultList();
	}

	// trazi drzave ciji naziv sadrzi odredjenu rec ili imaju populaciju vecu od
	// zadate
	public List<Country> findByNameContainsOrPopulationGreaterThan(String name,
			int population) {
		Query q = em.createQuery("SELECT c FROM Country c WHERE name LIKE :name or "
				+ "population > :population");
		q.setParameter("name", "%" + name + "%");
		q.setParameter("population", population);
		return q.getResultList();
	}
}
