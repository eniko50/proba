package vp.ds.ispiti.komande;

import vp.ds.ispiti.EvidencijaIspita;
import vp.ds.ispiti.model.Predmet;

public class ObrisiPredmet implements Komanda {
	
	private EvidencijaIspita evidencija;
	private Predmet predmet;
	
	public ObrisiPredmet(EvidencijaIspita evidencija, Predmet predmet) {
		this.evidencija = evidencija;
		this.predmet = predmet;
	}
	
	@Override
	public void izvrsi() {
		evidencija.oznaciPredmetKaoObrisan(predmet);
	}

	@Override
	public void ponisti() {
		evidencija.oznaciPredmetKaoNeobrisan(predmet);
	}

}
