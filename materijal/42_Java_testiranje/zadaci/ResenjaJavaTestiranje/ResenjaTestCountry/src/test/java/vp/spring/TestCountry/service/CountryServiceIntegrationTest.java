package vp.spring.TestCountry.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CountryServiceIntegrationTest {
	
	@Autowired
	CountryService countryService;
	
	@Test
	public void testClassifyCountry() {
		// Srbija ima izmedju jedan i 10 miliona stanovnika
		int result = countryService.classifyCountry(1L); 
		assertEquals(2, result);
		
		// Francuska ima vise od 10 miliona stanovnika
		result = countryService.classifyCountry(2L); 
		assertEquals(1, result);	
	}
}
