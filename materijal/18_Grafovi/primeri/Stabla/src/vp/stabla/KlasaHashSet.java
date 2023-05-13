package vp.stabla;

import java.util.HashSet;

public class KlasaHashSet {
	public static void main(String[] args) {
		HashSet<Drzava> drzave = new HashSet<>();
		Drzava d1 = new Drzava("sr", "Srbija");
		boolean uspeo = drzave.add(d1);
		System.out.println("Dodavanje Srbije uspesno? " + uspeo);
		uspeo = drzave.add(d1);
		System.out.println("Ponovno dodavanje Srbije uspesno? " + uspeo);
		
		
		drzave.add(new Drzava("fr", "Francuska"));
		drzave.add(new Drzava("it", "Italija"));
		
		boolean postoji = drzave.contains(d1);
		System.out.println("Drzava Srbija postoji u skupu? " + postoji);
		
		drzave.remove(d1);
		postoji = drzave.contains(d1);
		System.out.println("Drzava Srbija postoji u skupu? " + postoji);		
	}
}
