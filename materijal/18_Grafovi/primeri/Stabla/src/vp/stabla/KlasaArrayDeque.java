package vp.stabla;

import java.util.ArrayDeque;

public class KlasaArrayDeque {
	
	public static void main(String[] args) { 
		ArrayDeque<Drzava> drzave = new ArrayDeque<>();
		Drzava d1 = new Drzava("sr", "Srbija");
		drzave.addLast(d1); 
		drzave.addLast(new Drzava("fr", "Francuska")); 
		
		Drzava d3 = new Drzava("it", "Italija");
		drzave.addFirst(d3);
		
		Drzava prva = drzave.getFirst();
		System.out.println("Na pocetku reda je drzava " + 
				prva.getOznaka() + " " + prva.getNaziv());
		
		Drzava poslednja = drzave.getLast();
		System.out.println("Na kraju reda je drzava " + 
				poslednja.getOznaka() + " " + poslednja.getNaziv());
		
		drzave.removeFirst();
		prva = drzave.getFirst();
		System.out.println("Na pocetku reda je drzava " + 
				prva.getOznaka() + " " + prva.getNaziv());		
	}
}
