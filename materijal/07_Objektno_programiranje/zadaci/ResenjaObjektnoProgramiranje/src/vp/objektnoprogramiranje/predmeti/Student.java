package vp.objektnoprogramiranje.predmeti;

public class Student {
	String ime;
	String prezime;
	String brojIndeksa;
	Predmet[] ispiti;
	int[] ocene;
	
	void ispisiStudenta() {
		String zaIspis = brojIndeksa + " " + ime + " " + prezime + 
				". Polozio: ";
		//dodavanje imena ispita, ocena i bodova na tekst za ispis
		for (int i = 0; i < ispiti.length; i++) {
			zaIspis += ispiti[i].naziv + " (" + ispiti[i].espb + ") "; 
 		}
		System.out.println(zaIspis);
	}
	
	void oceneIznad(int granica) {
		for (int i = 0; i < ispiti.length; i++) {
			if (ocene[i] > granica) {
				System.out.println(ispiti[i].naziv);
			}
		}
	}
	
	// metoda se zove isto kao i prethodna, ali ima drugacije parametre
	void oceneIznad(int granicaOcene, int granicaBodova) {
		for (int i = 0; i < ispiti.length; i++) {
			if (ocene[i] > granicaOcene && ispiti[i].espb > granicaBodova) {
				System.out.println(ispiti[i].naziv);
			}
		}
	}
	
	double prosecnaOcena() {
		int suma = 0;
		for (int i = 0; i < ocene.length; i++) {
			suma += ocene[i];
		}
		return (double) suma / ocene.length;		
	}
	
	Predmet najboljiIspit() {
		int maksIndeks = 0;
		for (int i = 1; i < ispiti.length; i++) {
			if (ocene[i] > ocene[maksIndeks]) {
				maksIndeks = i;
			}
		}		
		return ispiti[maksIndeks];
	}
	
	Predmet najlosijiIspit() {
		int minIndeks = 0;
		for (int i = 1; i < ispiti.length; i++) {
			if (ocene[i] < ocene[minIndeks]) {
				minIndeks = i;
			}
		}		
		return ispiti[minIndeks];
	}
	
	
	
	
}
