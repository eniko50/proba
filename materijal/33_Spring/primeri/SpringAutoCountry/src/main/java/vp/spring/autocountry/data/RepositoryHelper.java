package vp.spring.autocountry.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Klasa ilustruje korišćenje Spring Expression Language na primeru
 * pristupa podacima iz CountryRepository Bean-a
 * @author Goran
 *
 */
@Component
public class RepositoryHelper {
	
	// vrednost ce biti injektovana u trenutku instanciranja beana
	@Value("#{countryRepository.getCountries().size()}")
	private int numberOfCountries;
	
	public int getNumberOfCountries() {
		return numberOfCountries;
	}
	
	@Value("#{countryRepository.getCountries()[0].getName()}")
	String firstCountryName;

	public String getFirstCountryName() {
		return firstCountryName;
	}
}
