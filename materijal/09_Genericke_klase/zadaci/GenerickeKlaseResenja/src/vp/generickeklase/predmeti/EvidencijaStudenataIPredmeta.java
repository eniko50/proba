package vp.generickeklase.predmeti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EvidencijaStudenataIPredmeta {
//	private static Student[] studenti = new Student[100];
//	private static Predmet[] predmeti = new Predmet[100];
//	private static int ukupnoStudenata = 0;
//	private static int ukupnoPredmeta = 0;

	private static ArrayList<Student> studenti = new ArrayList<Student>();
	private static ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
	
	public static void main(String[] args) {
		
		int opcija = 0;

		do {
			// unos opcije
			prikaziMeni();
			System.out.println("\nUnesite opciju: ");	
			String opcijaTekst = unesi();
			opcija = Integer.parseInt(opcijaTekst);

			switch (opcija) {
			case 1:
				prikaziStudente();
				break;
			case 2: 
				pronadjiStudenta();
				break;
			case 3:
				dodajStudenta();
				break;
			case 4:
				izmeniStudenta();
				break;
			case 5:
				obrisiStudenta();
				break;
			case 6:
				prikaziPredmete();
				break;
			case 7: 
				pronadjiPredmet();
				break;
			case 8:
				dodajPredmet();
				break;
			case 9:
				izmeniPredmet();
				break;
			case 10:
				obrisiPredmet();
				break;
			case 11:
				System.out.println("Hvala sto ste koristili program");
			default:
			}
		} while (opcija != 11);
	}
	
	private static void prikaziMeni() {
		System.out.println("===================================");
		System.out.println("1. Prikaz svih studenata");
		System.out.println("2. Pronalazenje studenta");
		System.out.println("3. Unos studenta");
		System.out.println("4. Izmena studenta");
		System.out.println("5. Brisanje studenta");
		System.out.println("6. Prikaz svih predmeta");
		System.out.println("7. Pronalazenje predmeta");
		System.out.println("8. Unos predmeta");
		System.out.println("9. Izmena predmeta");
		System.out.println("10. Brisanje predmeta");
		System.out.println("11. Izlaz");
	}
	
	private static String unesi() {
		String unos = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			 unos = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return unos;
	}
	
	private static void prikaziStudente() {
		System.out.println("Studenti u evidenciji: ");
//		for (int i = 0; i < ukupnoStudenata; i++) {
//			if (!studenti[i].isObrisan()) {
//				studenti[i].ispisiStudenta();
//			}
//		}
		for (int i = 0; i < studenti.size(); i++) {
			if (!studenti.get(i).isObrisan()) {
				studenti.get(i).ispisiStudenta();
			}
		}
	}
	
	private static void pronadjiStudenta() {
		Student trazeniStudent = preuzmiPoBrojuIndeksa();
		if (trazeniStudent != null) {
			System.out.print("Podaci trazenog studenta: ");
			trazeniStudent.ispisiStudenta();
		} else {
			System.out.println("Trazeni student ne postoji");
		}
	}
	
	private static Student preuzmiPoBrojuIndeksa() {
		//unos broja indeksa
		System.out.print("Unesite broj indeksa: ");
		String trazeniIndeks = unesi(); 
		
//		for (int i = 0; i < ukupnoStudenata; i++) {
//			if (studenti[i].getBrIndeksa().equals(trazeniIndeks) &&
//					!studenti[i].isObrisan()) {
//				return studenti[i];
//			}
//		}
		for (int i = 0; i < studenti.size(); i++) {
			if (studenti.get(i).getBrIndeksa().equals(trazeniIndeks) &&
					!studenti.get(i).isObrisan()) {
				return studenti.get(i);
			}
		}
		return null;
	}
	
	private static void dodajStudenta() {
		System.out.print("Unesite ime studenta: ");
		String unesenoIme = unesi();
		System.out.print("Unesite prezime studenta: ");
		String unesenoPrezime = unesi();
		System.out.print("Unesite broj indeksa studenta: ");
		String uneseniIndeks = unesi();
		
		Student noviStudent = new Student(unesenoIme, unesenoPrezime, uneseniIndeks);
//		studenti[ukupnoStudenata++] = noviStudent; 
		studenti.add(noviStudent);
	}
	
	private static void izmeniStudenta() {
		Student studentZaIzmenu = preuzmiPoBrojuIndeksa();
		if (studentZaIzmenu != null) {
			System.out.print("Unesite izmenjeno ime studenta: ");
			String unesenoIme = unesi();
			System.out.print("Unesite izmenjeno prezime studenta: ");
			String unesenoPrezime = unesi();
			System.out.print("Unesite izmenjeni broj indeksa studenta: ");
			String uneseniIndeks = unesi();
			
			studentZaIzmenu.setIme(unesenoIme);
			studentZaIzmenu.setPrezime(unesenoPrezime);
			studentZaIzmenu.setBrIndeksa(uneseniIndeks);			
		} else {
			System.out.println("Trazeni student ne postoji.");
		}
	}
	
	private static void obrisiStudenta() {
		Student studentZaBrisanje = preuzmiPoBrojuIndeksa();
		if (studentZaBrisanje != null) {
			studentZaBrisanje.setObrisan(true);
		}
	}
	
	private static void prikaziPredmete() {
		System.out.println("Predmeti u evidenciji: ");
//		for (int i = 0; i < ukupnoPredmeta; i++) {
//			if (!predmeti[i].isObrisan()) {
//				predmeti[i].ispisiPredmet();
//			}
//		}
		for (int i = 0; i < predmeti.size(); i++) {
			if (!predmeti.get(i).isObrisan()) {
				predmeti.get(i).ispisiPredmet();
			}
		}
	}
	
	private static void pronadjiPredmet() {
		Predmet trazeniPredmet = preuzmiPredmetPoOznaci();
		if (trazeniPredmet != null) {
			System.out.print("Podaci trazenog predmeta: ");
			trazeniPredmet.ispisiPredmet();
		} else {
			System.out.println("Trazeni predmet ne postoji");
		}
	}
	
	private static Predmet preuzmiPredmetPoOznaci() {
		System.out.print("Unesite oznaku predmeta: ");
		String trazenaOznaka = unesi(); 
		
//		for (int i = 0; i < ukupnoPredmeta; i++) {
//			if (predmeti[i].getOznaka().equals(trazenaOznaka) &&
//					!predmeti[i].isObrisan()) {
//				return predmeti[i];
//			}
//		}
		for (int i = 0; i < predmeti.size(); i++) {
			if (predmeti.get(i).getOznaka().equals(trazenaOznaka) &&
					!predmeti.get(i).isObrisan()) {
				return predmeti.get(i);
			}
		}
		return null;
	}
	
	private static void dodajPredmet() {
		System.out.print("Unesite naziv predmeta: ");
		String uneseniNaziv = unesi();
		System.out.print("Unesite broj ESPB bodova za predmet: ");
		String uneseniBodovi = unesi();
		
		//oznaka predmeta se automatski dodeljuje
//		Predmet noviPredmet = new Predmet(String.valueOf(ukupnoPredmeta+1), 
//				uneseniNaziv, Integer.valueOf(uneseniBodovi));
		Predmet noviPredmet = new Predmet(String.valueOf(predmeti.size()+1), 
				uneseniNaziv, Integer.valueOf(uneseniBodovi));
//		predmeti[ukupnoPredmeta++] = noviPredmet; 
		predmeti.add(noviPredmet);
	}
	
	private static void izmeniPredmet() {
		Predmet predmetZaIzmenu = preuzmiPredmetPoOznaci();
		if (predmetZaIzmenu != null) {
			// za oznaku je realizovano da korisnik ne moze da je menja
			System.out.print("Unesite izmenjeni naziv predmeta: ");
			String uneseniNaziv = unesi();
			System.out.print("Unesite izmenjeni broj ESPB bodova: ");
			String uneseniBodovi = unesi();
			
			predmetZaIzmenu.setNaziv(uneseniNaziv);
			predmetZaIzmenu.setEspb(Integer.valueOf(uneseniBodovi));			
		} else {
			System.out.println("Trazeni predmet ne postoji.");
		}
	}
	
	private static void obrisiPredmet() {
		Predmet predmetZaBrisanje = preuzmiPredmetPoOznaci();
		if (predmetZaBrisanje != null) {
			predmetZaBrisanje.setObrisan(true);
		}
	}
}
