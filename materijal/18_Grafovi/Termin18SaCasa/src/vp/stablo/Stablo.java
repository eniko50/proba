package vp.stablo;

import java.util.ArrayList;

public class Stablo<T> {
	
	private Cvor<T> koren;
	
	public Cvor<T> dodaj(Cvor<T> roditelj, Cvor<T> novi) {
		// roditelj null, inicijalizuj koren na novi
		if (roditelj == null ) {
			koren = novi;
		} else {
			// else podesiti u novom roditelja, i ubaciti u listu potomaka roditelja
			novi.roditelj = roditelj;
			roditelj.potomci.add(novi);
		}
		
		// vratiti novi cvor
		return novi;
	}
	
	public Cvor<T> dodaj(Cvor<T> roditelj, T element) {
		Cvor<T> novi = new Cvor<>(element, roditelj);
		return dodaj(roditelj, novi);
	}
	
	public void obrisi(Cvor<T> cvorZaBrisanje) {
		
	}
	
	public Cvor<T> pronadji(T element) {
		// treba da radi po slicnom principu kao ispis, rekurzivno
		return null;
	}
	
	public void ispis() {
		ispis(koren, 0);
	}
	
	private void ispis(Cvor<T> cvor, int nivo) {
		for (int i = 0; i < nivo; i++) {
			System.out.print(" ");
		}
		System.out.println(cvor.vrednost);
		for (Cvor<T> potomak : cvor.potomci) {
			ispis(potomak, nivo + 1);
		}
	}
	
	
	public class Cvor<S> {
		private S vrednost;
		private ArrayList<Cvor<S>> potomci = new ArrayList<>();
		private Cvor<S> roditelj;
		
		public Cvor(S vrednost, Cvor<S> roditelj) {
			super();
			this.vrednost = vrednost;
			this.roditelj = roditelj;
		}
		
		
	}

}
