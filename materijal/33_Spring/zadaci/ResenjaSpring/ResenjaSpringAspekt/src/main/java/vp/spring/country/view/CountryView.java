package vp.spring.country.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.country.authorization.AuthorizationManager;
import vp.spring.country.model.Country;
import vp.spring.country.model.Place;
import vp.spring.country.service.CountryService;
import vp.spring.country.service.PlaceService;

@Component
public class CountryView {
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private PlaceService placeService;
	
	@Autowired 
	AuthorizationManager authorizationManager; // for login

	public void start() {
		int option = 0;
		
		// prijava na sistem
		boolean loginOk = login();
		if (!loginOk) {
			System.out.println("Invalid username or password.");
			return;
		}

		do {
			// unos opcije
			displayMenu();
			System.out.println("\nPlease choose the option: ");	
			option = Integer.parseInt(input());

			switch (option) {
			case 1:
				showCountries();
				break;
			case 2: 
				findCountry();
				break;
			case 3:
				addCountry();
				break;
			case 4:
				modifyCountry();
				break;
			case 5:
				removeCountry();
				break;
			case 6: 
				classifyCountry();
				break;
			case 7:
				showPlaces();
				break;
			case 8:
				findPlace();
				break;
			case 9:
				addPlace();
				break;
			case 10:
				modifyPlace();
				break;
			case 11:
				removePlace();
				break;
			}
		} while (option != 12);
	}
	
	private void displayMenu() {
		System.out.println("1. Show all countries");
		System.out.println("2. Find country");
		System.out.println("3. Add country");
		System.out.println("4. Modify country");
		System.out.println("5. Delete country");
		System.out.println("6. Classify country");
		System.out.println("7. Show places");
		System.out.println("8. Find place");
		System.out.println("9. Add place");
		System.out.println("10. Modify place");
		System.out.println("11. Delete place");		
		System.out.println("12. Exit");
	}
	
	private boolean login() {
		System.out.print("Username: ");
		String username = input();
		
		System.out.print("Password: ");
		String password = input();
		
		boolean retVal = authorizationManager.login(username, password);
		return retVal;
	}
	
	private String input() {
		String text = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			 text = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}
	
	private void showCountries() {
		List<Country> countries = countryService.findAll();
		for (Country c: countries) {
			System.out.println(c);
		}
	}
	
	private void findCountry() {
		// mozemo traziti po razlicitim kriterijumima
		// prikazujemo podmeni da korisnik izabere kriterijum
		System.out.println("1. find by id");
		System.out.println("2. find by name");
		System.out.println("3. find by population");
		System.out.println("4. find by name or population");
		
		String text = input();
		
		switch (text) {
		case "1":
			System.out.print("Id: ");
			int id = Integer.parseInt(input());
			Country country = countryService.findOne(id);
			System.out.println(country);
			break;
		case "2":
			System.out.print("Name: ");
			String name = input();
			List<Country> countries = countryService.findByName(name);
			for (Country c: countries) {
				System.out.println(c);
			}
			break;
		case "3":
			System.out.print("Population: ");
			int population = Integer.parseInt(input());
			countries = countryService.findByPopulation(population);
			for (Country c: countries) {
				System.out.println(c);
			}
			break;
		case "4":
			System.out.print("Name: ");
			name = input();
			System.out.print("Population: ");
			population = Integer.parseInt(input());
			countries = countryService.findByNameOrPopulation(name, population);
			for (Country c: countries) {
				System.out.println(c);
			}
			break;
		}
	}
	
	private void addCountry() {
		System.out.print("Id: ");
		int id = Integer.parseInt(input());
		System.out.print("Name: ");
		String name = input();
		System.out.println("Population: ");
		int population = Integer.parseInt(input());
		
		countryService.save(new Country(id, name, population));
	}
	
	private void modifyCountry() {
		System.out.print("Id: ");
		int id = Integer.parseInt(input());
		System.out.print("Name: ");
		String name = input();
		System.out.println("Population: ");
		int population = Integer.parseInt(input());
		
		Country country = countryService.findOne(id);
		if (country != null) {
			// save ce modifikovati postojecu drzavu
			countryService.save(new Country(id, name, population));
		}
	}
	
	private void removeCountry() {
		System.out.print("Id: ");
		int id = Integer.parseInt(input());
		countryService.remove(id);
	}
	
	private void classifyCountry() {
		System.out.print("Id: ");
		int id = Integer.parseInt(input());
		int result = countryService.classifyCountry(id);
		switch (result) {
		case 1:
			System.out.println("Large");
			break;
		case 2:
			System.out.println("Medium");
			break;
		case 3:
			System.out.println("Small");
			break;
		}
	}
	
	private void showPlaces() {
		List<Place> places = placeService.findAll();
		for (Place p: places) {
			System.out.println(p);
		}
	}
	
	private void findPlace() {
		// pretraga se vrsi po id-u
		System.out.println("Id: ");
		String text = input();
		
		System.out.println(placeService.findOne(Integer.valueOf(text)));
	}
	
	private void addPlace() {
		System.out.print("Id: ");
		int id = Integer.parseInt(input());
		System.out.print("Zip code: ");
		int zipCode = Integer.parseInt(input());
		System.out.print("Name: ");
		String name = input();
		System.out.println("Country id: ");
		int countryId = Integer.parseInt(input());
		Country country = countryService.findOne(countryId);
		
		placeService.save(new Place(id, zipCode, name, country));
	}
	
	private void modifyPlace() {
		System.out.print("Id: ");
		int id = Integer.parseInt(input());
		System.out.print("Zip code: ");
		int zipCode = Integer.parseInt(input());
		System.out.print("Name: ");
		String name = input();
		
		Place place = placeService.findOne(id);
		if (place != null) {
			// save ce modifikovati postojece mesto
			// drzava se ne modifikuje, pa nije ni vazno koju ima vrednost - zato je stavljeno null
			placeService.save(new Place(id, zipCode, name, null)); 
		}
	}
	
	private void removePlace() {
		System.out.print("Id: ");
		int id = Integer.parseInt(input());
		placeService.remove(id);
	}
	
	
}
