package vp.sekvencijalnestrukture.lista.dvostruka;

public class DvostrukoSpregnutaLista<E> {
	Cvor<E> glava = null;
	int brojEl = 0;
	

	public void dodaj(E element) {
		if (brojEl == 0) {
			glava = new Cvor<>(element);
		} else {
			Cvor<E> temp = glava;
			while (temp.sledeci != null) 
				temp = temp.sledeci;
			
			temp.sledeci = new Cvor<>(element, temp, null);
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
			for (int i = 0; i < pozicija; i++)
				temp = temp.sledeci;

			Cvor<E> prethodniCvor = temp.prethodni;
			prethodniCvor.sledeci = noviCvor;
			temp.prethodni = noviCvor;

			noviCvor.prethodni = prethodniCvor;
			noviCvor.sledeci = temp;
		}
		brojEl++;
	}
	
	public boolean postoji(E element) {
		Cvor<E> temp = glava;
		while (temp != null) {
			if (temp.vrednost == element) {
				return true;
			}
			temp = temp.sledeci;
		}
		return false;
	}

	public E preuzmi(int pozicija) {
		Cvor<E> temp = glava;
		for (int i = 0; i < pozicija; i++) {
			temp = temp.sledeci;
		}
		return temp.vrednost;
	}

	public void isprazni() {
		glava = null;
		brojEl = 0;
	}

	public void obrisi(int pozicija) {
		if (pozicija == 0) {
			glava = glava.sledeci;
			glava.prethodni = null;
		} else {
			Cvor<E> temp = glava;
			for (int i = 0; i < pozicija; i++) {
				temp = temp.sledeci;
			}
			temp.prethodni.sledeci = temp.sledeci;
			temp.sledeci.prethodni = temp.prethodni;
		}
		brojEl--;
	}

	public void obrisi(E element) {
		if (glava == null) { // za praznu listu
			return;
		}
		if (glava.vrednost == element) {
			glava = glava.sledeci;
			glava.prethodni = null;
		} else {
			Cvor<E> temp = glava;
			while (temp != null) {
				if (temp.vrednost == element) {
					temp.prethodni.sledeci = temp.sledeci;
					if (temp.sledeci != null) { // ako nije poslednji
						temp.sledeci.prethodni = temp.prethodni; 
					}					
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
		Cvor<T> prethodni;
		Cvor<T> sledeci;
		T vrednost;

		public Cvor(T vrednost, Cvor<T> prethodni, Cvor<T> sledeci) {
			this.vrednost = vrednost;
			this.prethodni = prethodni;
			this.sledeci = sledeci;
		}

		public Cvor(T vrednost) {
			this(vrednost, null, null);
		}
	}
}
