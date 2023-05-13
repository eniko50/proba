package vp.spring.securitycountry;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import vp.spring.securitycountry.web.dto.CountryDTO;
import vp.spring.securitycountry.web.dto.LoginDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CountryControllerTest {
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	// JWT token za pristup REST servisima. Bice dobijen pri logovanju
	private String accessToken;
	
	// pre izvrsavanja testa, prijava da bismo dobili token
	@Before
	public void login() {
		ResponseEntity<String> responseEntity = 
				restTemplate.postForEntity("/api/login", 
						new LoginDTO("admin", "12345"), 
						String.class);
		// preuzmemo token jer ce nam trebati za testiranje REST kontrolera
		accessToken = responseEntity.getBody();
	}
	
    @Test
    public void testGetCountries() {
    	// postavimo JWT token u zaglavlje zahteva da bi bilo dozvoljeno da pozovemo funkcionalnost
    	HttpHeaders headers = new HttpHeaders();
    	headers.add("X-Auth-Token", accessToken);
    	//kreiramo objekat koji saljemo u sklopu zahteva 
    	// objekat nema telo, vec samo zaglavlje, jer je rec o GET zahtevu
    	HttpEntity<Object> httpEntity = new HttpEntity<Object>(headers);
    	
    	// posaljemo zahtev koji ima i zaglavlje u kojem je JWT token
        ResponseEntity<CountryDTO[]> responseEntity =
            restTemplate.exchange("/api/countries",
            						  HttpMethod.GET,
            						  httpEntity,
            						  CountryDTO[].class);
            
        CountryDTO[] countries = responseEntity.getBody();
        
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(3, countries.length);        
        assertEquals(Long.valueOf(3), countries[2].getId());
        assertEquals("Italy", countries[2].getName());
        assertEquals(60800000, countries[2].getPopulation());
    }
}
