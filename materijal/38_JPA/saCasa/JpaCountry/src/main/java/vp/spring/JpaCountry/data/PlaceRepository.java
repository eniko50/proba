package vp.spring.JpaCountry.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import vp.spring.JpaCountry.model.Place;

@Component
@Transactional
public class PlaceRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<Place> findAll() {
		Query query = entityManager
				.createQuery("select p from Place p");
		
		return query.getResultList();
	}
	
	public Place findOne(Long id) {
		return entityManager.find(Place.class, id);
	}

	public List<Place> findByCountryId(Long countryId) {
		Query query = entityManager
				.createQuery("select p from Place p where "
						+ "p.country.id = :countryId");
		query.setParameter("countryId", countryId);
		
		return query.getResultList();
	}

	public Place save(Place place) {
		entityManager.persist(place);
		return place;
	}
	
	
}
