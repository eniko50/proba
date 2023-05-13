package vp.stabla.stablo;

import java.util.ArrayList;

public class Stablo<E> {
	private Cvor<E> koren;
	
	public Cvor dodaj(Cvor roditelj, E element) {
		Cvor<E> noviCvor = new Cvor<>(element, roditelj);
		if (roditelj == null) {
			koren = noviCvor;
		} else {
			roditelj.potomci.add(noviCvor);
		}
		return noviCvor;
	}
	
	public Cvor<E> pronadji(E element) {
		return pronadji(koren, element);
	}
	
	private Cvor<E> pronadji(Cvor<E> roditelj, E element) {
		if (roditelj.vrednost.equals(element)) {
			return roditelj;
		} 
		
		for (int i = 0; i < roditelj.potomci.size(); i++) {
			Cvor<E> cvor = roditelj.potomci.get(i);
			Cvor<E> rezultat = pronadji(cvor, element);
			if (rezultat != null) {
				return rezultat;
			}
		}
		return null;
	}
	
	public void ispisi() {
		if (koren != null) {
			ispisi(koren, 0);
		}
	}
	
	private void ispisi(Cvor<E> cvor, int indent) {
		for (int i = 0 ; i < indent; i++) { // dodamo broj tabova u skladu sa nivoom u stablu
			System.out.print("\t");
		}
		System.out.println(cvor.vrednost);
		for (int i = 0; i < cvor.potomci.size(); i++) {
			ispisi(cvor.potomci.get(i), indent + 1); // potomci su na jednom nivou ispod
		}
	}
	
	public boolean ukloni(Cvor<E> cvor) {
		if (cvor == koren) {
			koren = null;
			return true;
		} else {
			return cvor.roditelj.potomci.remove(cvor);	
		}		
	}	
	
	public class Cvor<E> {
		private E vrednost;
		private Cvor<E> roditelj;
		private ArrayList<Cvor<E>> potomci = new ArrayList<>();
		
		Cvor(E vrednost, Cvor<E> roditelj) {
			this.vrednost = vrednost;
			this.roditelj = roditelj;
		}	
		
		public E getVrednost() {
			return vrednost;
		}
	}
}
