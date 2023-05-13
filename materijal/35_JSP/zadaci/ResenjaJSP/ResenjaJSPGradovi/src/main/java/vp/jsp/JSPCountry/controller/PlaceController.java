package vp.jsp.JSPCountry.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vp.jsp.JSPCountry.model.Country;
import vp.jsp.JSPCountry.model.Place;
import vp.jsp.JSPCountry.service.CountryService;
import vp.jsp.JSPCountry.service.PlaceService;

@Controller
public class PlaceController {
	@Autowired
	PlaceService placeService;
	
	@Autowired
	CountryService countryService;
	
	@RequestMapping(value="/placesPage")
	public String redirectToPlacesPage(HttpServletRequest request, Map<String, Object> model) {
		// parametar zahteva je drzava cije gradove prikazujemo
		String countryId = request.getParameter("countryId");
		
		// preuzmemo tu drzavu
		Country country = countryService.findOne(Integer.valueOf(countryId));
		//ubacimo drzavu u model jer treba JSP stranici
		model.put("country", country);
		
		// preuzmemo gradove te drzave
		List<Place> places = placeService.findByCountryId(Integer.valueOf(countryId));
		
		// ubacimo mesta u model da bi te podatke prikazali na jsp stranici
		model.put("places", places);
		
		// prikaz JSP stranice countryPlaces.jsp
		return "countryPlaces";
	}
	
	@RequestMapping(value="/addPlacePage")
	public String redirectToAddPlacePage(HttpServletRequest request, Map<String, Object> model) {
		// parametar zahteva je drzava kojoj dodajemo grad
		String countryId = request.getParameter("countryId");
		// preuzmemo drzavu sa tim id-om kako bi njene trenutne podatke prikazali korisniku
		Country country = countryService.findOne(Integer.valueOf(countryId));
		// ubacimo drzavu u model da bi njene podatke prikazali na jsp stranici
		model.put("country", country);
		
		// redirekcija na stranicu za dodavanje grada
		return "addPlace";
	}
	
	// dodavanje novog grada
	@RequestMapping(value="/places/add", method=RequestMethod.POST)
	public String addPlace(HttpServletRequest request) {
		int countryId = Integer.valueOf(request.getParameter("countryId"));
		int zipCode = Integer.valueOf(request.getParameter("zipCode"));
		String name = request.getParameter("placeName");
		
		// preuzmemo drzavu po idu
		Country country = countryService.findOne(countryId);
		
		Place place = new Place(-1, zipCode, name, country); 
		placeService.save(place);
		
		// redirekcija na spisak gradova drzave. Parametar je id drzave cije gradove prikazujemo
		return "redirect:/placesPage?countryId=" + countryId;  
	}
	
	@RequestMapping(value="/places/remove", method=RequestMethod.GET)
	public String removePlace(HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		
		// preuzmemo drzavu u kojoj je mesto jer se treba redirektovati na mesta te drzave
		Place place = placeService.findOne(id);
		int countryId = place.getCountry().getId();
		
		// brisemo mesto
		placeService.remove(id);
		
		// redirekcija na spisak gradova drzave. Parametar je id drzave cije gradove prikazujemo
		return "redirect:/placesPage?countryId=" + countryId;  
	}
	
	@RequestMapping(value="/modifyPlacePage")
	public String redirectToModifyPlacePage(HttpServletRequest request, Map<String, Object> model) {
		// parametar zahteva je grad koji menjamo
		String id = request.getParameter("id");
		// preuzmemo grad sa tim id-om kako bi njegove trenutne podatke prikazali korisniku
		Place place = placeService.findOne(Integer.valueOf(id));
		// ubacimo grad u model da bi se podaci prikazali na JSP stranici
		model.put("place", place);
		// ubacimo i drzavu u kojoj je grad model da bi i njene podatke prikazali na jsp stranici
		model.put("country", place.getCountry());
		
		// redirekcija na stranicu za dodavanje grada
		return "modifyPlace";
	}
	
	// izmena grada
	@RequestMapping(value="/places/modify", method=RequestMethod.POST)
	public String modifyPlace(HttpServletRequest request) {
		int countryId = Integer.valueOf(request.getParameter("countryId"));
		int id = Integer.valueOf(request.getParameter("id"));
		int zipCode = Integer.valueOf(request.getParameter("zipCode"));
		String name = request.getParameter("placeName");
		
		// ne moramo u mesto da postavljamo drzavu, jer se pri modifikaciji drzava ne moze modifikovati, 
		// pa nije vazno sta je u mestu u atributu drzava		
		Place place = new Place(id, zipCode, name, null);  
		// izmena mesta
		placeService.save(place);
		
		// redirekcija na spisak gradova drzave. Parametar je id drzave cije gradove prikazujemo
		return "redirect:/placesPage?countryId=" + countryId;  
	}
	
	
}
