package vp.sekvencijalnestrukture.lista.dvostruka;

public class Test {
	public static void main(String[] args) {
		DvostrukoSpregnutaLista<String> imena = new DvostrukoSpregnutaLista<>();
		imena.dodaj("Marko");
		imena.dodaj("Petar");
		imena.dodaj("Milan");
		imena.dodaj("Jovan", 1); // na poziciju 1 dodajemo ovaj element
		
		for (int i = 0; i < imena.getVelicina(); i++) {
			System.out.println(imena.preuzmi(i));
		}
		System.out.println("==================");
		
		// element na poziciji 2 je
		System.out.println(imena.preuzmi(2));
		
		// da li postoji element Petar
		System.out.println(imena.postoji("Petar"));
		
		// brisanje elementa na poziciji 2
		imena.obrisi(2);
		System.out.println("==================");
		for (int i = 0; i < imena.getVelicina(); i++) {
			System.out.println(imena.preuzmi(i));
		}
		System.out.println("==================");
		
		// brisanje elementa "Milan"
		imena.obrisi("Milan");
		System.out.println("==================");
		for (int i = 0; i < imena.getVelicina(); i++) {
			System.out.println(imena.preuzmi(i));
		}
		System.out.println("==================");
	}
}
