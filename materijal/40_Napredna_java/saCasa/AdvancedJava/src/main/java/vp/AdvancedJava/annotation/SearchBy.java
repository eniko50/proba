package vp.AdvancedJava.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotacija određuje po kojim atributima je anotirani entitet pretraziv
 * @author Goran
 *
 */
@Retention(RetentionPolicy.RUNTIME) // anotacija treba da bude dostupna u toku izvrsavanja programa
@Target(ElementType.TYPE) // anotacija moze biti primenjena nad tipom podatka (nad klasom, a ne nad metodom ili atributom) 
public @interface SearchBy {
	enum SearchType {EQUALS, CONTAINS}; // moguce vrednosti za strategiju provere jednakosti
	
	String[] fields(); // niz atributa po kojima je entitet pretraziv
	SearchType searchType(); // strategija provere jednakosti - da li se proverava deo sadrzaja ili ceo sadrzaj
}
