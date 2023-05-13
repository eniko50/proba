package vp.spring.country.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vp.spring.country.data.CountryRepository;
import vp.spring.country.service.CountryService;
import vp.spring.country.view.CountryView;

@Configuration
public class AppConfig {
	
	@Bean
	public CountryService countryService(CountryRepository countryRepository) {
		//countryRepository Bean injektuje Spring iz kontejnera
		return new CountryService(countryRepository);
		
		// Cak bi i eksplicitni poziv metode countryRepository() Spring presreo i 
		// vratio bean objekat iz kontejnera
		// Primer - ovaj kod bi vratio da su ova dva objekta jednaka jer se vraca ista
		// instanca iz Spring kontejnera
		// CountryRepository cr1 = countryRepository();
		// CountryRepository cr2 = countryRepository();
		// System.out.println(cr1 == cr2);
	}
	
	// definisanje Spring beana
	// ime metode je proizvoljno, gleda se tip koji vraca
	// Spring preuzima instanciranje i dobavljanje objekata tog tipa
	@Bean
	public CountryRepository countryRepository() {
		return new CountryRepository();
	}
	
	@Bean
	public CountryView countryView(CountryService countryService) {
		// posto je CountryService bean, Spring ce injektovati objekat kao argument konstruktora
		return new CountryView(countryService);
	}
}
