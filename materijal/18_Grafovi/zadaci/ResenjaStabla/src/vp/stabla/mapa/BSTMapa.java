package vp.stabla.mapa;

public class BSTMapa<V>  { // kljucevi su tipa int
	private ProsirenoBinarnoStablo<V> stablo = new ProsirenoBinarnoStablo<>();
	private int brElemenata = 0;
	
	public void dodaj(int kljuc, V vrednost) {
		stablo.dodaj(kljuc, vrednost);
		brElemenata++;
	}
	
	public V preuzmi(int kljuc) {
		return stablo.pronadji(kljuc);
	}

	public boolean obrisi(int kljuc) {
		boolean rezultat = stablo.ukloni(kljuc);
		if (rezultat) {
			brElemenata--;
		}
		return rezultat;
	}
	
	public int velicina() {
		return brElemenata;
	}
	
	public Object[] preuzmiSveVrednosti() {
		return stablo.preuzmiSadrzaje(); // sadrzaj nazivamo dodatni objekat u cvoru stabla
	}
	
	public Object[] preuzmiSveKljuceve() {
		return stablo.preuzmiVrednosti(); // kljuc u stablu zovemo vrednost
	}
}
