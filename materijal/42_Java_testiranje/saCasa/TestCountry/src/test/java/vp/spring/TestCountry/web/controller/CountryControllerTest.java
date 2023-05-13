package vp.spring.TestCountry.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import vp.spring.TestCountry.data.CountryRepository;
import vp.spring.TestCountry.model.Country;
import vp.spring.TestCountry.web.dto.CountryDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CountryControllerTest {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
    private TestRestTemplate restTemplate;
	
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
	public void addCountry() {
		CountryDTO dto = new CountryDTO(0L, "Kostarita", 17283);
		
		ResponseEntity<CountryDTO> response =
				restTemplate.postForEntity("/api/countries", dto, CountryDTO.class);
		
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		
		CountryDTO country = response.getBody();
		assertEquals("Kostarita", country.getName());
		assertEquals(17283, country.getPopulation());
		
		countryRepository.deleteById(country.getId());
	}
	
	@Test
	public void deleteCountry() {
		Country country = countryRepository
				.save(new Country("Liberland", 76612));

//		long countBefore = countryRepository.count();
		
		restTemplate.delete("/api/countries/" + country.getId());
		
//		long countAfter = countryRepository.count();
//		assertEquals(countBefore - 1, countAfter);
		
		Optional<Country> deletedCountry = countryRepository
				.findById(country.getId());
		
		assertFalse(deletedCountry.isPresent());
	}
}









