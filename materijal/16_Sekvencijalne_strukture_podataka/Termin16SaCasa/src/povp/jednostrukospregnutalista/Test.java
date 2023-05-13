package povp.jednostrukospregnutalista;

public class Test {

	public static void main(String[] args) {
		JednostrukoSpregnutaLista<String> lista = new JednostrukoSpregnutaLista<>();
		
		// primer instanciranja unutrasnje klase, ako je ona public 
		// (ova linija ce se kompajlirati ako stavite da je klasa Cvor u listi public)
		// JednostrukoSpregnutaLista<String>.Cvor<String> c = lista.new Cvor<>("test", null);
		
		lista.dodaj("Novi Sad");
		lista.dodaj("Kragujevac");
		lista.dodaj("Alibunar");
		lista.dodaj("Bela Crkva");
		
		for (int i = 0; i < lista.brojElemenata(); i++) {
			System.out.println("Lista[" + i + "] = " + lista.preuzmi(i));
		}
		
		lista.dodaj("Beograd", 2);
		
		lista.izbaci(2);
		lista.izbaci("Beograd");
		lista.izbaci("Alibunar");

		if (lista.postoji("Novi Sad")) {
			System.out.println("Novi Sad postoji");
		}
		
		for (int i = 0; i < lista.brojElemenata(); i++) {
			System.out.println("Lista[" + i + "] = " + lista.preuzmi(i));
		}
		
		lista.obrisiSve();
	}

}
