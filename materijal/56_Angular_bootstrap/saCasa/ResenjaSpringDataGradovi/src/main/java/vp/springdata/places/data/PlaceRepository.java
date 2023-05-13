package vp.springdata.places.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import vp.springdata.places.model.Place;


/**
 * Klasa je zaduzena za evidenciju podataka o drzavama. Podaci se perzistiraju u
 * relacionoj bazi podataka 
 * 
 * @author Goran
 *
 */
@Component
public interface PlaceRepository extends JpaRepository<Place, Long> {

	public List<Place> findByNameContains(String name);
	public List<Place> findByCountryId(Long countryId);
}
