package vp.stabla;

import java.util.LinkedList;

public class KlasaLinkedList {

	public static void main(String[] args) {
		LinkedList<Drzava> drzave = new LinkedList<>();
		Drzava d1 = new Drzava("sr", "Srbija");
		drzave.add(d1); 
		drzave.add(new Drzava("fr", "Francuska")); 
		
		Drzava d3 = new Drzava("it", "Italija");
		drzave.add(1, d3);
		
		System.out.println("========== LinkedList ==============");
		System.out.println("Inicijalni spisak drzava");
		for (int i = 0; i < drzave.size(); i++) { 
			System.out.println(drzave.get(i).getOznaka() + " " + 
					drzave.get(i).getNaziv());
		}
		
		boolean postoji = drzave.contains(d3);
		System.out.println("Drzava Italija je u listi? " + postoji);
		
		int index = drzave.indexOf(d3);
		System.out.println("Drzava Italija je na poziciji " + index);
		
		drzave.remove(d3);
		System.out.println("Konacni spisak drzava");
		for (int i = 0; i < drzave.size(); i++) { 
			System.out.println(drzave.get(i).getOznaka() + " " + 
					drzave.get(i).getNaziv());
		}


	}

}
