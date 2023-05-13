package vp.stabla.mapa;

import java.util.ArrayList;

public class ProsirenoBinarnoStablo<E> { // E je tip dodatnog objekta koji se pridruzuje cvoru
	private Cvor<E> koren;
	
	public void dodaj(int element, E sadrzaj) {
		if (koren == null) {
			koren = new Cvor<E>(element, sadrzaj);
		} else {
			dodaj(koren, element, sadrzaj);
		}
	}
	
	private void dodaj(Cvor<E> cvor, int element, E sadrzaj) {
		if (cvor.vrednost == element) {
			return;
		} else if (cvor.vrednost > element) { // ide se u levo podstablo
			if (cvor.levi == null) {
				cvor.levi = new Cvor<E>(element, sadrzaj);
			} else {
				dodaj(cvor.levi, element, sadrzaj);
			}
		} else {
			if (cvor.desni == null) {
				cvor.desni = new Cvor<E>(element, sadrzaj);
			} else {
				dodaj(cvor.desni, element, sadrzaj);
			}
		}
	}
	
	public E pronadji(int element) {
		return pronadji(koren, element);
	}
	
	private E pronadji(Cvor<E> cvor, int element) {
		if (cvor == null) {
			return null;
		}
		
		if (cvor.vrednost == element) {
			return cvor.sadrzaj;
		} else if (cvor.vrednost > element) {
			return pronadji(cvor.levi, element);
		} else {
			return pronadji(cvor.desni, element);
		}
	}
	
	public void ispisi() {
		if (koren != null) {
			ispisi(koren, 0);
		}
	}
	
	private void ispisi(Cvor cvor, int indent) {
		for (int i = 0 ; i < indent; i++) { // dodamo broj tabova u skladu sa nivoom u stablu
			System.out.print("\t");
		}
		System.out.println(cvor.vrednost);
		
		if (cvor.desni != null) {
			ispisi(cvor.desni, indent + 1);
		}
		if (cvor.levi != null) {
			ispisi(cvor.levi, indent + 1);
		}		
	}
	
	public Object[] preuzmiSadrzaje() {
		ArrayList<Cvor<E>> cvorovi = preuzmiSveCvorove();
		Object[] rezultat = new Object[cvorovi.size()];
		for (int i = 0; i < cvorovi.size(); i++) {
			rezultat[i] = cvorovi.get(i).sadrzaj;
		}
		return rezultat;
	} 
	
	public Object[] preuzmiVrednosti() {
		ArrayList<Cvor<E>> cvorovi = preuzmiSveCvorove();
		Object[] rezultat = new Object[cvorovi.size()];
		for (int i = 0; i < cvorovi.size(); i++) {
			rezultat[i] = cvorovi.get(i).vrednost;
		}
		return rezultat;
	}
	
	private ArrayList<Cvor<E>> preuzmiSveCvorove() {
		ArrayList<Cvor<E>> rezultat = new ArrayList<>();
		dodajCvorUListu(koren, rezultat);
		
		return rezultat;
	}
	
	private void dodajCvorUListu(Cvor<E> cvor, ArrayList<Cvor<E>> lista) {
		if (cvor != null) {
			lista.add(cvor);
			dodajCvorUListu(cvor.levi, lista);
			dodajCvorUListu(cvor.desni, lista);
		}
	}
	
	public boolean ukloni(int element) {
		if (koren == null) {
			return false;
		} 
		
		if (koren.vrednost == element) {
			koren = null;
			return true;
		} 
		
		return ukloni(koren, element);
	}
	
	private boolean ukloni(Cvor cvor, int element) {
		if (cvor.vrednost > element) {
			if (cvor.levi == null) {
				return false;
			}
			if (cvor.levi.vrednost == element) {
				cvor.levi = null;
				return true;
			} else {
				return ukloni(cvor.levi, element);
			}		
		} else {
			if (cvor.desni == null) {
				return false;
			}
			if (cvor.desni.vrednost == element) {
				cvor.desni = null;
				return true;
			} else {
				return ukloni(cvor.desni, element);
			}
		}
	}
	
	private class Cvor<E> {
		private int vrednost;
		private E sadrzaj;
		private Cvor<E> levi;
		private Cvor<E> desni;
		
		Cvor(int vrednost, E sadrzaj) {
			this.vrednost = vrednost;
			this.sadrzaj = sadrzaj;
		}		
	}
}
