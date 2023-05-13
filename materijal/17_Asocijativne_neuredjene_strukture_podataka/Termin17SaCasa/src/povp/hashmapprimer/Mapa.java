package povp.hashmapprimer;

public class Mapa<K, V> {
	
	private Cvor[] slotovi;
	private int brojSlotova = 10;
	private int brojElemenata;
	
	public Mapa() {
		slotovi = new Cvor[brojSlotova];
	}
	
	public Mapa(int brojSlotova) {
		this.brojSlotova = brojSlotova;
		slotovi = new Cvor[brojSlotova];
	}

	public void dodaj(K kljuc, V vrednost) {
		// kreiranje cvora
		Cvor<K, V> novi = new Cvor<>(kljuc, vrednost, null);
		
		// odredi hash
		int hash = kljuc.hashCode();
		
		// preuzmi element u odgovarajucem slotu
		int indeksSlota = Math.abs(hash) % brojSlotova;
		Cvor<K, V> tekuci = slotovi[indeksSlota];
		
		// ako je taj element null, dodaj novi cvor
		if (tekuci == null) {
			slotovi[indeksSlota] = novi;
		} else {
			// 	ako nije null, prolazak kroz listu do kraja, uvezivanje novog na kraj
			while (tekuci.sledeci != null) {
				tekuci = tekuci.sledeci;
			}
			tekuci.sledeci = novi;
		}
		
		brojElemenata++;
	}
	
	public void obrisi(K kljuc) {
		
	}
	
	public V preuzmi(K kljuc) {
		return null;
	}
	
	public int brojElemenata() {
		return brojElemenata;
	}
	
	public Object[] preuzmiKljuceve() {
		Object[] kljucevi = new Object[brojElemenata];
		int i = 0;
		for (Cvor cvor : slotovi) {
			while (cvor != null) {
				kljucevi[i] = cvor.kljuc;
				cvor = cvor.sledeci;
				i++;
			}
		}
		return kljucevi;
	}
	
	public Object[] preuzmiVrednosti() {
		return null;
	}
	
	private class Cvor<K, V> {
		private K kljuc;
		private V vrednost;
		private Cvor<K, V> sledeci;
		
		public Cvor(K kljuc, V vrednost, Cvor<K, V> sledeci) {
			super();
			this.kljuc = kljuc;
			this.vrednost = vrednost;
			this.sledeci = sledeci;
		}
		
		
	}
}
