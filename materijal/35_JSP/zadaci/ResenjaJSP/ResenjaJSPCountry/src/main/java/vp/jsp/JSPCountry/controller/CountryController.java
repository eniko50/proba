package vp.jsp.JSPCountry.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vp.jsp.JSPCountry.model.Country;
import vp.jsp.JSPCountry.service.CountryService;

@Controller
public class CountryController {
	@Autowired	
	CountryService countryService;
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", "Probna poruka");
		return "hellopage";
	}
	
	// metoda ce biti pozvana za url /api/countries/test
	@RequestMapping(value="/test") 
	public String test(Map<String, Object> model) {
		String s = "Hello!";
		model.put("message", s);
		return "hellopage"; // naziv jsp stranice koja treba biti prikazana nakon obrade zahteva
	}
	
	@RequestMapping(value="/countries") 
	public String getAllCountries(Map<String, Object> model) {
		List<Country> countries = countryService.findAll(); // preuzimanje liste drzava iz skladista
		
		model.put("countries", countries); // u request objekat ubacujemo objekat countries sa nazivom "countries"		
		
		return "countries"; // upucivanje na stranicu countries.jsp
	}
	
	@RequestMapping(value="/addCountryPage")
	public String redirectToAddCountryPage() {
		return "addCountry";
	}
	
	// istu metodu koristimo i za dodavanje i za izmenu drzave
	@RequestMapping(value="/countries/save", method=RequestMethod.POST)
	public String saveCountry(HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		int population = Integer.valueOf(request.getParameter("population"));
		
		Country country = new Country(id, name, population);
		countryService.save(country);
		
		// redirekcija na url /countries sto poziva metodu getAllCountries,
		// koja ce inicirati prikaz stranice countries.jsp
		return "redirect:/countries";  
	}
	
	@RequestMapping(value="/countries/remove", method=RequestMethod.GET)
	public String removeCountry(HttpServletRequest request) {
		// parametar zahteva je id drzave koju brisemo
		String id = request.getParameter("id");
		// brisanje drzave
		countryService.remove(Integer.valueOf(id));
		
		// redirekcija na url /countries sto poziva metodu getAllCountries,
		// koja ce inicirati prikaz stranice countries.jsp
		return "redirect:/countries";  
	}
	
	@RequestMapping(value="/modifyCountryPage")
	public String redirectToModifyCountryPage(HttpServletRequest request, Map<String, Object> model) {
		// parametar zahteva je drzava koju menjamo
		String id = request.getParameter("id");
		
		// preuzmemo drzavu sa tim id-om kako bi njene trenutne podatke prikazali korisniku
		Country country = countryService.findOne(Integer.valueOf(id));
		
		// ubacimo drzavu u model da bi njene podatke prikazali na jsp stranici
		model.put("country", country);
		
		// za modifikaciju drzave koristimo istu JSP stranicu kao i za dodavanje drzave
		return "addCountry";
	}
	
	@RequestMapping(value="/countries/search", method=RequestMethod.GET)
	public String searchCountry(HttpServletRequest request, Map<String, Object> model) {
		// kriterijum pretrage je u parametru zahteva
		String search = request.getParameter("searchValue");
		
		List<Country> countries = countryService.findByName(search);
		
		model.put("countries", countries); // u request objekat ubacujemo objekat countries sa nazivom "countries"
		// da bi u input polju ostala unesena vrednost, postavimo i nju u request da bude dostupna JSP stranici
		model.put("searchText", search); 
		
		return "countries"; // upucivanje na stranicu countries.jsp
	}
}
