package vp.stabla;

import java.util.HashMap;

public class KlasaHashMap {
	
	public static void main(String[] args) {
		HashMap<String, Drzava> drzave = new HashMap<>();
		Drzava d1 = new Drzava("sr", "Srbija");
		drzave.put(d1.getOznaka(), d1);
		
		Drzava d2 = new Drzava("fr", "Francuska");
		drzave.put(d2.getOznaka(), d2); 
		
		Drzava d3 = new Drzava("it", "Italija");
		drzave.put(d3.getOznaka(), d3);
		
		Drzava d = drzave.get("fr");
		System.out.println("Drzava sa kljucem fr ima naziv " + 
			d.getNaziv());
		
		drzave.remove("fr");
		d = drzave.get("fr");
		System.out.println("Drzava sa kljucem fr je " + d);
	}
}
