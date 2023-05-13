package vp.skup;

import vp.mapa.Mapa;

public class Skup<E> {
	// skup ne dozvoljava ubacivanje dva puta istog objekta
	// zato koristimo mapu za skladistenje, jer ubacivanje elementa 
	// ce "prepisati" postojeci elemnt (ne mogu biti 2 elementa sa istim kljucem)
	// zato kao kljuceve u mapi uzimamo elemente koje cemo ubacivati, jer oni
	// ne smeju da budu duplirani pri skladistenju
	private Mapa<E, Object> sadrzaj = new Mapa<>();
	// kljucevi u mapi su objekti koje skladistimo, a mapa zahteva i skladistenje vrednosti
	// tu uzimamo "dummy" prazan objekat samo zato da bi uskladistili neku vrednost uz kljuc
	private static final Object PRAZAN_OBJEKAT = new Object();
	
	
	public void dodaj(E element) {
		// dodavanje elementa koji vec postoji u mapi, ce pregaziti postojeci
		// tako da nikad nece biti uskladisten dva puta isti objekat, sto je 
		// zahtev da bi se struktura smatrala skupom
		sadrzaj.dodaj(element, PRAZAN_OBJEKAT); // kljuc je bitan, vrednost je obican prazan objekat
	}
	
	public boolean postoji(E element){
		return sadrzaj.preuzmi(element) != null;
	}
	
	public boolean obrisi(E element) {
		return sadrzaj.obrisi(element);
	}
	
	public Object[] preuzmiElemente() {
		// elementi skupa su uskladisteni kao kljucevi mape
		return sadrzaj.preuzmiSveKljuceve();
	}
}
