package povp.jednostrukospregnutalista;

public class JednostrukoSpregnutaLista<T> {
	
	private Cvor<T> glava;
	private int brojElemenata;
	
	public void dodaj(T element) {
		// kreiranje novog cvora
		Cvor<T> novi = new Cvor<T>(element, null);
		
		// ako je lista prazna, glava je novi cvor
		if (glava == null) {
			glava = novi;
		} else {
		// else, prolazak kroz listu do kraja
			Cvor<T> tekuci = glava;
			while (tekuci.sledeci != null) {
				tekuci = tekuci.sledeci;
			}
			// ubacivanje novog na kraj
			tekuci.sledeci = novi;
		}
		
		// br el ++
		brojElemenata++;
	}

	public void dodaj(T element, int pozicija) {
		// kreiranje novog cvora
		Cvor<T> novi = new Cvor<T>(element, null);
		
		// ako je na pocetak, glava je novi
		if (pozicija == 0) {
			novi.sledeci = glava;
			glava = novi;
		} else {
			// else, prolazak kroz listu do pozicije
			Cvor<T> tekuci = glava;
			for (int i = 0; i < pozicija - 1; i++) {
				tekuci = tekuci.sledeci;
			}
			// umetanje elementa na poziciju
			novi.sledeci = tekuci.sledeci;
			tekuci.sledeci = novi;
		}
		
		// br el ++
		brojElemenata++;
	}
	
	public void izbaci(int pozicija) {
		
	}
	
	public void izbaci(T element) {
		
	}
	
	public boolean postoji(T element) {
		return false;
	}
	
	public int brojElemenata() {
		return brojElemenata;
	}
	
	public T preuzmi(int pozicija) {
		Cvor<T> tekuci = glava;
		for (int i = 0; i < pozicija; i++) {
			tekuci = tekuci.sledeci;
		}
		return tekuci.vrednost;
	}
	
	public void obrisiSve() {
		
	}
	
	private class Cvor<S> {

		private S vrednost;
		private Cvor<S> sledeci;
		
		public Cvor(S vrednost, Cvor<S> sledeci) {
			super();
			this.vrednost = vrednost;
			this.sledeci = sledeci;
		}
	}
}
