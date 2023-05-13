package vp.jsp.JSPCountry.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vp.jsp.JSPCountry.model.Country;
import vp.jsp.JSPCountry.service.CountryService;

@Controller
public class CountryController {
	@Autowired	
	CountryService countryService;
	
	@RequestMapping("/")
	public String welcome(HttpServletRequest request) {
		request.setAttribute("message", "Poruka u zahtevu.");
		
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
	public String getAllCountries(HttpServletRequest request,
			@RequestParam(required=false, defaultValue="") String query) {
		List<Country> countries = countryService.findByName(query); // preuzimanje liste drzava iz skladista
		
		request.setAttribute("countries", countries); // u request objekat ubacujemo objekat countries sa nazivom "countries"		
		
		return "countries"; // upucivanje na stranicu countries.jsp
	}
	
//	@GetMapping("/countries/search")
//	public String filterCountries(@RequestParam String query,
//								  HttpServletRequest request) {
//		List<Country> countries = countryService.findByName(query);
//		
//		request.setAttribute("countries", countries);		
//		
//		return "countries";
//	}
	
	@RequestMapping(value="/addCountryPage")
	public String redirectToAddCountryPage() {
		return "addCountry";
	}
	
	
	@RequestMapping(value="/countries/add", method=RequestMethod.POST)
	public String addCountry(@RequestParam int id,
							 @RequestParam String name,
							 @RequestParam int population,
							 HttpServletRequest request) {
//		String name = request.getParameter("name");
//		String population = request.getParameter("population");
		
//		Country country = new Country(-1, name, Integer.parseInt(population)); // id ce biti postavljen pri snimanju
		Country country = new Country(id, name, population);
		countryService.save(country);
		
		// redirekcija na url /countries sto poziva metodu getAllCountries,
		// koja ce inicirati prikaz stranice countries.jsp
		return "redirect:/countries";  
	}
	
	@GetMapping("/countries/delete/{id}")
	public String deleteCountry(@PathVariable int id) {
		countryService.remove(id);
		
		return "redirect:/countries";
	}

	@GetMapping("/countries/edit/{id}")
	public String editCountry(@PathVariable int id,
			HttpServletRequest request) {
		Country country = countryService.findOne(id);
		
		request.setAttribute("country", country);
		
		return "addCountry";
	}






}
