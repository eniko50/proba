package vp.jpa.places.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.jpa.places.model.Country;
import vp.jpa.places.model.Place;


/**
 * Klasa je zaduzena za evidenciju podataka o gradovima. Podaci se perzistiraju u
 * relacionoj bazi podataka 
 * 
 * @author Goran
 *
 */
@Component
@Transactional // izvrsice metode u transakciji (kreirace novu transakciju ako poziv metode nije u transakciji)
public class PlaceRepository {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	CountryRepository countryRepository;

	public List<Place> findAll() {
		Query q = em.createQuery("SELECT p FROM Place p");

		return q.getResultList();
	}

	public Place findOne(Long id) {
		return em.find(Place.class, id);
	}

	public Place save(Place place) {
		// save radi i snimanje i izmenu
		// ako prosledjeni entitet ima validan id, smatra se da je rec o izmeni
		
		if (place.getId() != null) {
			return em.merge(place);	
		} else {
			em.persist(place);
			return place;		
		}
		
	}
	
	public void delete(Long id) {
		em.remove(findOne(id));
	}

	public List<Place> findByCountryId(Long countryId) {
		// preuzmemo prvo drzavu
		Country country = countryRepository.findOne(countryId);
		// vratimo gradove iz drzave
		return new ArrayList<Place>(country.getPlaces());
	}
	
	public List<Place> findByNameContains(String name) {
		Query q = em.createQuery("SELECT p FROM Place p WHERE name LIKE :name");
		q.setParameter("name", "%" + name + "%"); 
		return q.getResultList();
	}
}
