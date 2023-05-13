package vp.ds.ispiti.komande;

import vp.ds.ispiti.EvidencijaIspita;
import vp.ds.ispiti.model.Predmet;

public class DodajPredmet implements Komanda {

	private EvidencijaIspita evidencija;
	private Predmet predmet;
	
	public DodajPredmet(EvidencijaIspita evidencija, Predmet predmet) {
		this.evidencija = evidencija;
		this.predmet = predmet;
	}
	
	@Override
	public void izvrsi() {
		evidencija.dodajPredmet(predmet);
	}

	@Override
	public void ponisti() {
		evidencija.obrisiPredmet(predmet);
	}

}
