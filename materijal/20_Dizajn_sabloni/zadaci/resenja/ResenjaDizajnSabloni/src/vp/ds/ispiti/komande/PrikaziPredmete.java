package vp.ds.ispiti.komande;

import java.util.List;

import vp.ds.ispiti.model.Predmet;

public class PrikaziPredmete implements Komanda {

	private List<Predmet> predmeti;
	
	public PrikaziPredmete(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	@Override
	public void izvrsi() {
		System.out.println("Predmeti u evidenciji: ");
		for (int i = 0; i < predmeti.size(); i++) {
			if (!predmeti.get(i).isObrisan()) {
				predmeti.get(i).ispisiPredmet();
			}
		}
	}

	@Override
	public void ponisti() {
		
	}

}
