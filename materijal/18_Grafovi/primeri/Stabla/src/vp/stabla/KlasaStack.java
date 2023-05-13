package vp.stabla;

import java.util.Stack;

public class KlasaStack {
	
	public static void main(String[] args) { 
		Stack<Drzava> drzave = new Stack<>();
		Drzava d1 = new Drzava("sr", "Srbija");
		drzave.push(d1);
		
		drzave.push(new Drzava("fr", "Francuska"));
		drzave.push(new Drzava("it", "Italija"));
		
		Drzava d = drzave.peek();
		System.out.println("Na vrhu steka je: " + d.getOznaka() + " " + d.getNaziv());
		
		int udaljenost = drzave.search(d1);
		System.out.println("Drzava Srbija je udaljena od vrha steka " + udaljenost);
		
		drzave.pop();
		d = drzave.peek();
		System.out.println("Na vrhu steka je: " + d.getOznaka() + " " + d.getNaziv());
	}
}
