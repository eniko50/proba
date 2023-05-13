package vp.stabla.stablo;

public class Test {
	public static void main(String[] args) {
		Stablo<String> stablo = new Stablo<>();
		
		stablo.dodaj(null, "Milan");
		
		Stablo<String>.Cvor<String> cvor = stablo.pronadji("Milan");
		
		stablo.dodaj(cvor, "Petar");
		stablo.dodaj(cvor, "Zoran");
		stablo.dodaj(cvor, "Ivana");
		
		cvor = stablo.pronadji("Petar");
		stablo.dodaj(cvor, "Nada");
		
		cvor = stablo.pronadji("Zoran");
		stablo.dodaj(cvor, "Milica");
		stablo.dodaj(cvor, "Marko");
		
		cvor = stablo.pronadji("Ivana");
		stablo.dodaj(cvor, "Ana");
		stablo.dodaj(cvor, "Jelena");
		
		cvor = stablo.pronadji("Milica");
		stablo.dodaj(cvor, "Nenad");
		
		stablo.ispisi();
		
		cvor = stablo.pronadji("Zoran");
		stablo.ukloni(cvor);
	
		System.out.println("==================");
		System.out.println("Stablo nakon uklanjanja cvora: ");
		stablo.ispisi();
		
		cvor = stablo.pronadji("Milan");
		stablo.ukloni(cvor);
		
	}
}
