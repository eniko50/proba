package vp.ds.ispiti.komande;

import java.util.List;

import vp.ds.ispiti.Util;
import vp.ds.ispiti.model.Predmet;

public class PronadjiPredmet implements Komanda {

	List<Predmet> predmeti;
	
	public PronadjiPredmet(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	@Override
	public void izvrsi() {
		Predmet trazeniPredmet = preuzmiPredmetPoOznaci();
		if (trazeniPredmet != null) {
			System.out.print("Podaci trazenog predmeta: ");
			trazeniPredmet.ispisiPredmet();
		} else {
			System.out.println("Trazeni predmet ne postoji");
		}
	}

	@Override
	public void ponisti() {		
	}
	
	private Predmet preuzmiPredmetPoOznaci() {
		System.out.print("Unesite oznaku predmeta: ");
		String trazenaOznaka = Util.unesi(); 
		
		for (int i = 0; i < predmeti.size(); i++) {
			if (predmeti.get(i).getOznaka().equals(trazenaOznaka) &&
					!predmeti.get(i).isObrisan()) {
				return predmeti.get(i);
			}
		}
		return null;
	}


}
