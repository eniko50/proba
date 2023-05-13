package vp.ds.ispiti.komande;

import java.util.List;

import vp.ds.ispiti.Util;
import vp.ds.ispiti.model.Predmet;

public class ObrisiPredmet implements Komanda {
	
	private List<Predmet> predmeti;
	
	public ObrisiPredmet(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	private Predmet predmet;
	
	@Override
	public void izvrsi() {
		predmet = preuzmiPredmetPoOznaci();
		if (predmet != null) {
			predmet.setObrisan(true);
		}
		
	}

	@Override
	public void ponisti() {
		predmet.setObrisan(false);
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
