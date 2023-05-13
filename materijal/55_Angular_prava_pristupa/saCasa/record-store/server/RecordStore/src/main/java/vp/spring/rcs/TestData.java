package vp.spring.rcs;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.rcs.model.Author;
import vp.spring.rcs.model.Record;
import vp.spring.rcs.model.Style;
import vp.spring.rcs.service.AuthorService;
import vp.spring.rcs.service.RecordService;
import vp.spring.rcs.service.StyleService;

@Component
public class TestData {

	@Autowired
	AuthorService authorService;

	@Autowired
	StyleService styleService;
	
	@Autowired
	RecordService recordService;

	/*
	 * Inicijalizacija testnih podataka. 
	 */
	@PostConstruct
	public void init(){
		Author milesDavis = new Author("Miles Davis");
		authorService.save(milesDavis);
		
		Author johnColtrane = new Author("John Coltrane");
		authorService.save(johnColtrane);
		
		Author bobDylan = new Author("Bob Dylan");
		authorService.save(bobDylan);
		
		Style coolJazz = new Style("Cool jazz");
		styleService.save(coolJazz);

		Style jazz = new Style("Jazz");
		styleService.save(jazz);
		
		Style avantGardeJazz = new Style("Avant-garde jazz");
		styleService.save(avantGardeJazz);
		
		Style rockAndRoll = new Style("Rock and roll");
		styleService.save(rockAndRoll);
		
		Record highway61Revisited = new Record("Highway 61 Revisited", "https://upload.wikimedia.org/wikipedia/en/9/95/Bob_Dylan_-_Highway_61_Revisited.jpg",
				700, bobDylan);
		highway61Revisited.getStyles().add(rockAndRoll);
		recordService.save(highway61Revisited);
		
		Record birthOfTheCool = new Record("Birth of the Cool","https://upload.wikimedia.org/wikipedia/en/a/a8/Birth_of_the_Cool.jpg",
				950, milesDavis);
		birthOfTheCool.getStyles().add(jazz);
		birthOfTheCool.getStyles().add(coolJazz);
		recordService.save(birthOfTheCool);
		
		Record interstellarSpace = new Record("Interstellar Space", "https://upload.wikimedia.org/wikipedia/en/2/26/John_Coltrane_Interstellar_Space.jpg", 
				500, johnColtrane);
		interstellarSpace.getStyles().add(jazz);
		interstellarSpace.getStyles().add(avantGardeJazz);
		recordService.save(interstellarSpace);
	}
	
}
