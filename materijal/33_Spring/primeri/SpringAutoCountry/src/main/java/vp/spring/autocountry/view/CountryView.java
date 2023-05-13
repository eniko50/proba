package vp.spring.autocountry.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.autocountry.model.Country;
import vp.spring.autocountry.service.CountryService;

@Component
public class CountryView {
	@Autowired
	private CountryService countryService;
	
	public void start() {
		int option = 0;

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
			}
		} while (option != 8);
	}
	
	private void displayMenu() {
		System.out.println("1. Show all countries");
		System.out.println("2. Find country");
		System.out.println("3. Add country");
		System.out.println("4. Modify country");
		System.out.println("5. Delete country");
		System.out.println("6. Classify country");
		System.out.println("7. Show all places");
		System.out.println("8. Exit");
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
	
}
