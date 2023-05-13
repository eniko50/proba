package vp.ds.ispiti.komande;

import java.util.List;

import vp.ds.ispiti.Util;
import vp.ds.ispiti.model.Predmet;

public class IzmeniPredmet implements Komanda {

	private List<Predmet> predmeti;

	private String stariNaziv;
	
	private int stariBodovi;
	
	private String trazenaOznaka;
	
	public IzmeniPredmet(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	@Override
	public void izvrsi() {
		System.out.print("Unesite oznaku predmeta: ");
		trazenaOznaka = Util.unesi(); 

		Predmet predmetZaIzmenu = preuzmiPredmetPoOznaci();
		if (predmetZaIzmenu != null) {
			stariNaziv = predmetZaIzmenu.getNaziv();
			stariBodovi = predmetZaIzmenu.getEspb();
			
			System.out.print("Unesite izmenjeni naziv predmeta: ");
			String uneseniNaziv = Util.unesi();
			System.out.print("Unesite izmenjeni broj ESPB bodova: ");
			String uneseniBodovi = Util.unesi();
			
			predmetZaIzmenu.setNaziv(uneseniNaziv);
			predmetZaIzmenu.setEspb(Integer.valueOf(uneseniBodovi));			
		} else {
			System.out.println("Trazeni predmet ne postoji.");
		}
		
	}

	@Override
	public void ponisti() {
		Predmet predmetZaIzmenu = preuzmiPredmetPoOznaci();
		if (predmetZaIzmenu != null) {			
			predmetZaIzmenu.setNaziv(stariNaziv);
			predmetZaIzmenu.setEspb(stariBodovi);			
		} else {
			System.out.println("Trazeni predmet ne postoji.");
		}		
	}

	private Predmet preuzmiPredmetPoOznaci() {
		
		for (int i = 0; i < predmeti.size(); i++) {
			if (predmeti.get(i).getOznaka().equals(trazenaOznaka) &&
					!predmeti.get(i).isObrisan()) {
				return predmeti.get(i);
			}
		}
		return null;
	}

}
