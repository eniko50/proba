package vp.ds.ispiti.komande;

import java.util.List;

import vp.ds.ispiti.Util;
import vp.ds.ispiti.model.Predmet;

public class DodajPredmet implements Komanda {

	private List<Predmet> predmeti;
	
	private Predmet predmet;
	
	public DodajPredmet(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	
	
	@Override
	public void izvrsi() {
		System.out.print("Unesite naziv predmeta: ");
		String uneseniNaziv = Util.unesi();
		System.out.print("Unesite broj ESPB bodova za predmet: ");
		String uneseniBodovi = Util.unesi();
		
		predmet = new Predmet(String.valueOf(predmeti.size()+1), 
				uneseniNaziv, Integer.valueOf(uneseniBodovi));
		predmeti.add(predmet);
	}

	@Override
	public void ponisti() {
		predmeti.remove(predmet);
	}

}
