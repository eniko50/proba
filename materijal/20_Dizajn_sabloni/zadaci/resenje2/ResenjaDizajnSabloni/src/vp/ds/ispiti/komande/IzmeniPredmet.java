package vp.ds.ispiti.komande;

import vp.ds.ispiti.EvidencijaIspita;
import vp.ds.ispiti.model.Predmet;

public class IzmeniPredmet implements Komanda {

	private EvidencijaIspita evidencija;
	private Predmet noviPredmet;
	private String stariNaziv;
	private int stariBodovi;
	private String oznakaPredmeta;
	
	public IzmeniPredmet(EvidencijaIspita evidencija, Predmet stariPredmet, Predmet noviPredmet) {
		this.evidencija = evidencija;
		this.noviPredmet= noviPredmet;
		this.oznakaPredmeta = stariPredmet.getOznaka();
		this.stariNaziv = stariPredmet.getNaziv();
		this.stariBodovi = stariPredmet.getEspb();
	}
	
	@Override
	public void izvrsi() {
		evidencija.izmeniPredmet(oznakaPredmeta, noviPredmet);
	}

	@Override
	public void ponisti() {
		Predmet stariPredmet = new Predmet(oznakaPredmeta, stariNaziv, stariBodovi);
		evidencija.izmeniPredmet(oznakaPredmeta, stariPredmet);		
	}
}
