package vp.uvodujavu;

class Promenljive {

	public static void main(String[] args) {
		int redniBrojRacunara = 7;
		long serijskiBroj = 22568821239L;
		double cena = 39000.52;
		boolean imaCD = true;
		char os = 'W'; //tip instaliranog operativnog sistema
		String procesor = "Intel i7";
		
		System.out.println("Redni broj racunara: " + redniBrojRacunara);
		System.out.println("Serijski broj: " + serijskiBroj);
		System.out.print("\tCena: " + cena + "\n");
		System.out.println("\tSa CD uredjajem?: " + imaCD);
		System.out.println("\tOznaka operativnog sistema: " + os);
		System.out.println("\tProcesor: " + procesor);
			
		String s = "Novi Sad";
		System.out.println("Tekst je: " + s + "\n\n\n\n");
		
		String e = "Opstina \"Novi Sad\" je jedna od dve \n\tgradske opstine.";
		System.out.println(e);
		
		//konverzija tipova
		int x = 5;
		float y = 45.89f;
		double d = 24.74;
		
		y = x;
		System.out.println("y je: " + y);
		
		// x = d; //greska pri kompajliranju
		x = (int) d;
		System.out.println("x je: " + x);
	}
}
