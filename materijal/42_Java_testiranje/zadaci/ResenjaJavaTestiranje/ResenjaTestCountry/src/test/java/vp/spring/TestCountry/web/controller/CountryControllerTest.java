package vp.spring.TestCountry.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import vp.spring.TestCountry.model.Country;
import vp.spring.TestCountry.service.CountryService;
import vp.spring.TestCountry.web.dto.CountryDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CountryControllerTest {
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	@Autowired
	private CountryService countryService;
	
    @Test
    public void testGetCountries() {
    	// preuzmi samo drzave sa prve stranice ako idu 2 drzave po stranici
    	ResponseEntity<CountryDTO[]> responseEntity = 
    			restTemplate.getForEntity("/api/countries?page=0&size=2", 
    					CountryDTO[].class);
            
        CountryDTO[] countries = responseEntity.getBody();
        
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2, countries.length); 
        assertEquals("Serbia", countries[0].getName());
        assertEquals(7098000, countries[0].getPopulation());
        assertEquals("France", countries[1].getName());
        assertEquals(66810000, countries[1].getPopulation());
    }
    
    @Test
	public void testGetCountry() {
		ResponseEntity<CountryDTO> responseEntity =
	            restTemplate.getForEntity("/api/countries/3", CountryDTO.class);
		
		CountryDTO country = responseEntity.getBody();
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertNotNull(country);
        assertEquals("Italy", country.getName());
        assertEquals(60800000, country.getPopulation());
	}
    
    @Test
    public void testCreateCountry() {
    	int size = countryService.findAll().size(); // broj slogova pre ubacivanja novog
    	
    	ResponseEntity<CountryDTO> responseEntity =
	            restTemplate.postForEntity("/api/countries", 
	            		new CountryDTO(null, "Germany", 82670000), 
	            		CountryDTO.class);
    	
    	// provera odgovora servera
    	CountryDTO country = responseEntity.getBody();
    	assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertNotNull(country);
        assertEquals("Germany", country.getName());
        assertEquals(82670000, country.getPopulation());
        
        List<Country> countries = countryService.findAll();
        assertEquals(size + 1, countries.size()); // mora biti jedan vise slog sada nego pre
        // poslednja drzava u listi treba da bude nova drzava koja je ubacena u testu
        assertEquals("Germany", countries.get(countries.size()-1).getName());
        assertEquals(82670000, countries.get(countries.size()-1).getPopulation());
        
        // uklanjamo dodatu drzavu
        countryService.remove(country.getId());
    }
    
    @Test
    public void testUpdateCountry() {
    	ResponseEntity<CountryDTO> responseEntity =
	            restTemplate.exchange("/api/countries/1", HttpMethod.PUT, 
	            		new HttpEntity<CountryDTO>(new CountryDTO(1L, "Serbia", 10000000)),
	            		CountryDTO.class);
	            
    	CountryDTO country = responseEntity.getBody();
    	
    	// provera odgovora servera
    	assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertNotNull(country);
		assertEquals(Long.valueOf(1L), country.getId());
        assertEquals("Serbia", country.getName());
        assertEquals(10000000, country.getPopulation());
        
        // provera da li je izmenjen slog u bazi
        Country dbCountry = countryService.findOne(1L);
        assertEquals(Long.valueOf(1L), dbCountry.getId());
        assertEquals("Serbia", dbCountry.getName());
        assertEquals(10000000, dbCountry.getPopulation());
        
        // vracanje podatka na staru vrednost
        dbCountry.setPopulation(7098000);
        countryService.save(dbCountry);
    }
    
    @Test
    public void testDeleteCountry() {
    	// ubacimo drzavu koju cemo brisati
    	Country country = countryService.save(new Country("Germany", 82700000)); 
    	// preuzmemo trenutni broj drzava
    	int size = countryService.findAll().size();
    	
    	// poziv REST servisa za brisanje
    	ResponseEntity<Void> responseEntity =
	            restTemplate.exchange("/api/countries/" + country.getId(), 
	            HttpMethod.DELETE, new HttpEntity<Object>(null), Void.class);
    	
    	// provera odgovora servera
    	assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    	
    	// mora biti jedan manje slog sada nego pre
    	assertEquals(size - 1, countryService.findAll().size()); 
    }
    
    @Test
    public void testGetCountriesByName() {
    	// preuzmi samo drzave sa prve stranice ako idu 2 drzave po stranici
    	ResponseEntity<CountryDTO[]> responseEntity = 
    			restTemplate.getForEntity("/api/countries?name=Fra", CountryDTO[].class);
            
        CountryDTO[] countries = responseEntity.getBody();
        
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, countries.length); 
        assertEquals("France", countries[0].getName());
        assertEquals(66810000, countries[0].getPopulation());
    }
    
    @Test
    public void testGetCountriesByPopulation() {
    	// preuzmi samo drzave sa prve stranice ako idu 2 drzave po stranici
    	ResponseEntity<CountryDTO[]> responseEntity = 
    			restTemplate.getForEntity("/api/countries?population=66810000", CountryDTO[].class);
            
        CountryDTO[] countries = responseEntity.getBody();
        
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, countries.length); 
        assertEquals("France", countries[0].getName());
        assertEquals(66810000, countries[0].getPopulation());
    }
    
    @Test
    public void testGetCountriesByNameAndPopulation() {
    	// preuzmi samo drzave sa prve stranice ako idu 2 drzave po stranici
    	ResponseEntity<CountryDTO[]> responseEntity = 
    			restTemplate.getForEntity("/api/countries?name=Ser&population=65000000", 
    					CountryDTO[].class);
            
    	 CountryDTO[] countries = responseEntity.getBody();
         
         assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
         assertEquals(2, countries.length); 
         assertEquals("Serbia", countries[0].getName());
         assertEquals(7098000, countries[0].getPopulation());
         assertEquals("France", countries[1].getName());
         assertEquals(66810000, countries[1].getPopulation());
    }
}
