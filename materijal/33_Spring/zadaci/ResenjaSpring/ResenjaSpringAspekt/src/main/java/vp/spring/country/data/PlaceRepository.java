package vp.spring.country.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import vp.spring.country.model.Place;

/**
 * Klasa je zaduzena za evidenciju podataka o mestima.
 * Zbog jednostavnosti, podaci se skladiste u radnoj memoriji 
 * bez perzistiranja u bazi podataka
 * 
 * @author Goran
 *
 */
@Component
public class PlaceRepository {
	private List<Place> places = new ArrayList<Place>();
	
	// pri instanciranju se popunjava in-memory evidencija test podacima
	public PlaceRepository(CountryRepository countryRepository) {
		// drzava je Srbija. Dobija se od countryRepository
		places.add(new Place(1, 21000, "Novi Sad", countryRepository.findOne(1)));
		places.add(new Place(2, 11000, "Beograd", countryRepository.findOne(1)));
		places.add(new Place(3, 75008, "Paris", countryRepository.findOne(2)));
		places.add(new Place(4, 30149, "Rome", countryRepository.findOne(3)));
	}
	
	public List<Place> findAll() {
		return places;
	}
	
	public Place findOne(int id) {
		for (Place place: places) {
			if (place.getId() == id) {
				return place;
			}
		}
		return null;
	}
	
	public void save(Place place) {
		// save radi i snimanje i izmenu
		// ako prosledjeni entitet vec postoji u listi, onda je rec o izmeni
		Place existingPlace = findOne(place.getId());
		if (existingPlace == null) {
			places.add(place);
		} else { // ako mesto vec postoji u repozitorijumu, save radi izmenu podataka tog mesta
			existingPlace.setZipCode(place.getZipCode());
			existingPlace.setName(place.getName());
		}
	}
	
	// brise drzavu sa zadatim id-om
	public void delete(int id) {		
		Iterator<Place> it = places.iterator();
		while (it.hasNext()) {
			if (it.next().getId() == id) {
				it.remove();
				return;
			}
		}			
	}
}
