package vp.sekvencijalnestrukture.lista.jednostruka;

public class JednostrukoSpregnutaLista<E> {
	Cvor<E> glava = null; // referenca na prvi cvor u listi
	int brojEl = 0; // ukupan broj elemenata u listi

	public void dodaj(E element) // dodavanje na kraj liste
	{
		Cvor<E> noviCvor = new Cvor<>(element);
		if (brojEl == 0) {
			glava = noviCvor;
		} else {
			Cvor<E> temp = glava;
			while (temp.sledeci != null) {
				temp = temp.sledeci;
			}
			// poslednjem elementu postavimo da je sledeci novi element
			temp.sledeci = noviCvor;
		}
		brojEl++;
	}

	public void dodaj(E element, int pozicija) {
		Cvor<E> noviCvor = new Cvor<>(element);

		if (pozicija == 0) {
			noviCvor.sledeci = glava;
			glava = noviCvor;
		} else {
			Cvor<E> temp = glava;
			for (int i = 0; i < pozicija - 1; i++) {
				temp = temp.sledeci;
			}			
			noviCvor.sledeci = temp.sledeci;
			temp.sledeci = noviCvor;
		}
		brojEl++;
	}

	public E preuzmi(int pozicija) {
		Cvor<E> temp = glava;
		for (int i = 0; i < pozicija; i++)
			temp = temp.sledeci;

		return temp.vrednost;
	}
	
	public boolean postoji(E element) {
		Cvor<E> temp = glava;
		while (temp != null) {
			if (temp.vrednost.equals(element)) {
				return true;
			}
			temp = temp.sledeci;
		}
		return false;
	}

	public void isprazni() {
		glava = null;
		brojEl = 0;
	}
	
	public void obrisi(int pozicija) {
		if (pozicija == 0) {
			glava = glava.sledeci;
		} else {
			Cvor<E> temp = glava;
			for (int i = 0; i < pozicija - 1; i++) {
				temp = temp.sledeci;
			}
			temp.sledeci = temp.sledeci.sledeci;
		}
		brojEl--;
	}
	
	public void obrisi(E element) {
		if (glava == null) { // za praznu listu
			return;
		}
		if (glava.vrednost.equals(element)) {
			glava = glava.sledeci;
		} else {
			Cvor<E> temp = glava;
			while (temp.sledeci != null) {
				if (temp.sledeci.vrednost.equals(element)) {
					temp.sledeci = temp.sledeci.sledeci;
					break;
				}
				temp = temp.sledeci;
			}
		}
		brojEl--;
	}

	public int getVelicina() {
		return brojEl;
	}

	
	private class Cvor<T> {
		Cvor<T> sledeci;
		T vrednost;

		public Cvor(T vrednost, Cvor<T> sledeci) {
			this.vrednost = vrednost;
			this.sledeci = sledeci;
		}

		public Cvor(T vrednost) {
			this(vrednost, null); // poziv konstruktora ove klase koji prima dva
									// parametra
		}
	}
}
