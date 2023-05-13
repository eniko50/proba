package vp.mapa;

public class Mapa<K, V> {
	// slotovi su nizovi cvorova, pri cemu svaki cvor moze imati naredni cvor sa kojim je ulancan
	// ulancani su oni koji imaju istu hash vrednost
	Cvor[] slotovi;  
	int brojSlotova = 10;
	
	int brElemenata = 0; // broj elemenata u mapi
		
	public Mapa() {
		slotovi = new Cvor[brojSlotova]; // podrazumevani broj slotova je 10
	}
	
	public Mapa(int brojSlotova) {
		this.brojSlotova = brojSlotova;
		slotovi = new Cvor[brojSlotova];
	}
	
	public void dodaj(K kljuc, V vrednost) {
		int hash = kljuc.hashCode();
		// kreiramo novi cvor za ubacivanje u mapu
		Cvor<K, V> noviCvor = new Cvor<>(kljuc, vrednost);
		// hash oznacava indeks slota u nizu slotova (ograniceno na ukupan broj slotova)
		int indeksSlota = Math.abs(hash % brojSlotova); // hash moze biti i negativan, pa uzimamo apsolutnu vrednost jer su indeksi u nizu 0 i pozitivni brojevi
		Cvor<K,V> elementUSlotu = slotovi[indeksSlota];
		if (elementUSlotu == null) { // slot je prazan, ubacujemo novi element u slot
			slotovi[indeksSlota] = noviCvor;
		} else { //u slotu vec postoje elementi. Ubacujemo novi element nakon poslednjeg u tom slotu
			// dodjemo do poslednjeg elementa u slotu
			Cvor<K,V> prethodni = null;
			do {
				// ako vec postoji element sa ovim kljucem, postavimo mu novu vrednost
				if (elementUSlotu.kljuc.equals(kljuc)) {
					elementUSlotu.vrednost = vrednost;
					return;
				}
				prethodni = elementUSlotu;
				elementUSlotu = elementUSlotu.sledeci;
			} while (elementUSlotu != null);
			// prethodni je poslednji koji nije bio null
			prethodni.sledeci = noviCvor;
		}
		brElemenata++;
	}
	
	public V preuzmi(K kljuc) {
		Cvor<K, V> cvor = nadjiCvorPoKljucu(kljuc);
		return cvor != null ? cvor.vrednost : null;
	}

	public boolean obrisi(K kljuc) {
		int indeksSlota = Math.abs(kljuc.hashCode() % brojSlotova); 
		Cvor<K, V> element = slotovi[indeksSlota];
		if (element == null) {
			return false;
		}
		boolean rezultat = false;
		if (element.kljuc.equals(kljuc)) { 		// ako je prvi u slotu
			slotovi[indeksSlota] = element.sledeci;
			rezultat = true;
		} else { // pronalazimo ga u lancu elemenata u tom slotu
			while (element.sledeci != null) {
				if (element.sledeci.kljuc.equals(kljuc)) {
					element.sledeci = element.sledeci.sledeci;
					rezultat = true;
					break;
				}
				element = element.sledeci;	
			}
		}
		if (rezultat == true) { // smanjimo broj elemenata ako je obrisan
			brElemenata--;
		}
		return rezultat;
	}

	private Cvor<K, V> nadjiCvorPoKljucu(K kljuc) {
		int indeksSlota = Math.abs(kljuc.hashCode() % brojSlotova); 
		Cvor<K, V> element = slotovi[indeksSlota];
		while (element != null) {
			if (element.kljuc.equals(kljuc)) {
				return element;
			}
			element = element.sledeci;
		}
		return null;	
	}
	
	public int velicina() {
		return brElemenata;
	}
	
	public Object[] preuzmiSveVrednosti() {
		Object[] rezultat = new Object[brElemenata];
		int i = 0; // pozicija u nizu na koju ubacujemo element
		for (Cvor<K,V> cvor: slotovi) {
			// prolazimo kroz lanac cvorova u slotu i dodajemo ih u niz
			while (cvor != null) { 
				rezultat[i++] = cvor.vrednost;
				cvor = cvor.sledeci;
			}
		}		
		return rezultat;
	}
	
	public Object[] preuzmiSveKljuceve() {
		Object[] rezultat = new Object[brElemenata];
		int i = 0; // pozicija u nizu na koju ubacujemo element
		for (Cvor<K,V> cvor: slotovi) {
			// prolazimo kroz lanac cvorova u slotu i dodajemo ih u niz
			while (cvor != null) { 
				rezultat[i++] = cvor.kljuc;
				cvor = cvor.sledeci;
			}
		}		
		return rezultat;
	}
	
	private class Cvor<K, V> {
		K kljuc;
		V vrednost;
		Cvor sledeci;
		
		public Cvor(K kljuc, V vrednost, Cvor sledeci) {
			this.kljuc = kljuc;
			this.vrednost = vrednost;
			this.sledeci = sledeci;
		}
		
		public Cvor(K kljuc, V vrednost) {
			this(kljuc, vrednost, null);
		}
	}
	
}
