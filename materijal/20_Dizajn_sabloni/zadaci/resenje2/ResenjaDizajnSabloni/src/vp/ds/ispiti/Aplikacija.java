package vp.ds.ispiti;

import vp.ds.ispiti.komande.DodajIspitStudenta;
import vp.ds.ispiti.komande.DodajPredmet;
import vp.ds.ispiti.komande.DodajStudenta;
import vp.ds.ispiti.komande.IzmeniPredmet;
import vp.ds.ispiti.komande.IzmeniStudenta;
import vp.ds.ispiti.komande.ObrisiIspitStudenta;
import vp.ds.ispiti.komande.ObrisiPredmet;
import vp.ds.ispiti.komande.ObrisiStudenta;
import vp.ds.ispiti.model.Ispit;
import vp.ds.ispiti.model.Predmet;
import vp.ds.ispiti.model.Student;

/**
 * Ova klasa ima ulogu Client-a:
 * kreira komande i prosledjuje ih Invoker-u.
 * 
 * Ova klasa je takodje zaduzena za svu direktnu komunikaciju sa korisnikom aplikacije.
 */
public class Aplikacija {

	public static void main(String[] args) {
		
		EvidencijaIspita evidencija = EvidencijaIspita.getInstanca();
		evidencija.inicijalizujPodatke();
		int opcija = 0;

		do {
			prikaziMeni();
			System.out.println("\nUnesite opciju: ");
			String opcijaTekst = Util.unesi();
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
				dodajIspitStudenta();
				break;
			case 12:
				obrisiIspitStudenta();
				break;
			case 13:
				CommandManager.getInstance().ponisti();
				break;
			case 14:
				System.out.println("Hvala sto ste koristili program");
			default:
			}
		} while (opcija != 14);
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
		System.out.println("11. Dodavanje ispita studenta");
		System.out.println("12. Brisanje ispita studenta");
		System.out.println("13. Ponisti");
		System.out.println("14. Izlaz");
	}
	
	private static void dodajStudenta() {
		
		// preuzimanje podataka o studentu
		System.out.print("Unesite ime studenta: ");
		String unesenoIme = Util.unesi();
		System.out.print("Unesite prezime studenta: ");
		String unesenoPrezime = Util.unesi();
		System.out.print("Unesite broj indeksa studenta: ");
		String uneseniIndeks = Util.unesi();
		
		// kreiranje novog studenta i kreiranje komande
		Student noviStudent = new Student(unesenoIme, unesenoPrezime, uneseniIndeks);
		DodajStudenta komanda = new DodajStudenta(EvidencijaIspita.getInstanca(), noviStudent);
		
		// prosledjivanje komande command manager-u na izvrsavanje
		CommandManager.getInstance().izvrsi(komanda);
	}
	
	private static void izmeniStudenta() {
		System.out.print("Unesite broj indeksa studenta za izmenu: ");		
		String brojIndeksa = Util.unesi();
		Student trazeniStudent = EvidencijaIspita.getInstanca().preuzmiPoBrojuIndeksa(brojIndeksa);
		if (trazeniStudent != null) {
			System.out.print("Unesite izmenjeno ime studenta: ");
			String unesenoIme = Util.unesi();
			System.out.print("Unesite izmenjeno prezime studenta: ");
			String unesenoPrezime = Util.unesi();
			
			Student noviStudent = new Student(unesenoIme, unesenoPrezime, brojIndeksa);
			IzmeniStudenta komanda = new IzmeniStudenta(EvidencijaIspita.getInstanca(), trazeniStudent, noviStudent);
			CommandManager.getInstance().izvrsi(komanda);
			
		} else {
			System.out.println("Trazeni student ne postoji.");
		}
	}
	
	private static void obrisiStudenta() {
		System.out.println("Unesite broj indeksa studenta za brisanje: ");
		String brojIndeksa = Util.unesi();
		Student trazeniStudent = EvidencijaIspita.getInstanca().preuzmiPoBrojuIndeksa(brojIndeksa);
		if (trazeniStudent != null) {
			ObrisiStudenta komanda = new ObrisiStudenta(EvidencijaIspita.getInstanca(), trazeniStudent);
			CommandManager.getInstance().izvrsi(komanda);
		} else {
			System.out.println("Trazeni student ne postoji");
		}
	}
	
	private static void prikaziStudente() {
		System.out.println("Studenti u evidenciji: ");
		for (Student s : EvidencijaIspita.getInstanca().preuzmiStudente()) {
			if (!s.isObrisan()) {
				System.out.println(s);
			}
		}
	}
	
	private static void pronadjiStudenta() {
		System.out.println("Unesite broj indeksa studenta: ");
		String brojIndeksa = Util.unesi();
		Student trazeniStudent = EvidencijaIspita.getInstanca().preuzmiPoBrojuIndeksa(brojIndeksa);
		if (trazeniStudent != null) {
			System.out.print("Podaci trazenog studenta: ");
			System.out.println(trazeniStudent);
		} else {
			System.out.println("Trazeni student ne postoji");
		}
	}
	
	public static void dodajPredmet() {
		System.out.print("Unesite naziv predmeta: ");
		String uneseniNaziv = Util.unesi();
		System.out.print("Unesite broj ESPB bodova za predmet: ");
		String uneseniBodovi = Util.unesi();
		
		Predmet predmet = new Predmet(String.valueOf(EvidencijaIspita.getInstanca().getBrojPredmeta() + 1), 
				uneseniNaziv, Integer.valueOf(uneseniBodovi));
		DodajPredmet komanda = new DodajPredmet(EvidencijaIspita.getInstanca(), predmet);
		CommandManager.getInstance().izvrsi(komanda);
	}
	
	private static void obrisiPredmet() {
		System.out.print("Unesite oznaku predmeta: ");
		String trazenaOznaka = Util.unesi();
		Predmet trazeniPredmet = EvidencijaIspita.getInstanca().preuzmiPredmetPoOznaci(trazenaOznaka);
		if (trazeniPredmet != null) {
			ObrisiPredmet komanda = new ObrisiPredmet(EvidencijaIspita.getInstanca(), trazeniPredmet);
			CommandManager.getInstance().izvrsi(komanda);
		} else {
			System.out.println("Trazeni predmet ne postoji");
		}
	}
	
	private static void izmeniPredmet() {
		System.out.print("Unesite oznaku predmeta: ");
		String trazenaOznaka = Util.unesi(); 
		Predmet trazeniPredmet = EvidencijaIspita.getInstanca().preuzmiPredmetPoOznaci(trazenaOznaka);
		if (trazeniPredmet != null) {
			System.out.print("Unesite izmenjeni naziv predmeta: ");
			String uneseniNaziv = Util.unesi();
			System.out.print("Unesite izmenjeni broj ESPB bodova: ");
			String uneseniBodovi = Util.unesi();
			
			Predmet noviPredmet = new Predmet(trazenaOznaka, uneseniNaziv, Integer.valueOf(uneseniBodovi));
			IzmeniPredmet komanda = new IzmeniPredmet(EvidencijaIspita.getInstanca(), trazeniPredmet, noviPredmet);
			CommandManager.getInstance().izvrsi(komanda);
		} else {
			System.out.println("Trazeni predmet ne postoji.");
		}
	}
	
	public static void prikaziPredmete() {
		System.out.println("Predmeti u evidenciji: ");
		for (Predmet p : EvidencijaIspita.getInstanca().preuzmiPredmete()) {
			if (!p.isObrisan()) {
				System.out.println(p);
			}
		}
	}

	public static void pronadjiPredmet() {
		System.out.print("Unesite oznaku predmeta: ");
		String trazenaOznaka = Util.unesi();
		Predmet trazeniPredmet = EvidencijaIspita.getInstanca().preuzmiPredmetPoOznaci(trazenaOznaka);
		if (trazeniPredmet != null) {
			System.out.print("Podaci trazenog predmeta: ");
			System.out.println(trazeniPredmet);
		} else {
			System.out.println("Trazeni predmet ne postoji");
		}
	}
	
	private static void dodajIspitStudenta() {
		EvidencijaIspita evidencija = EvidencijaIspita.getInstanca();
		System.out.print("Unesite broj indeksa: ");
		String brojIndeksa = Util.unesi();
		Student student = evidencija.preuzmiPoBrojuIndeksa(brojIndeksa);
		
		System.out.print("Unesite oznaku predmeta: ");
		String trazenaOznaka = Util.unesi();
		Predmet predmet = evidencija.preuzmiPredmetPoOznaci(trazenaOznaka);

		if (student != null && predmet != null) {
			System.out.println("Unesite ocenu studenta:");
			int ocena = Integer.parseInt(Util.unesi());
			Ispit ispit = new Ispit(predmet, ocena);
			
			DodajIspitStudenta komanda = new DodajIspitStudenta(evidencija, ispit, student);
			CommandManager.getInstance().izvrsi(komanda);
		} else {
			System.out.println("Nepostojeci student ili predmet");
		}
	}
	
	private static void obrisiIspitStudenta() {
		EvidencijaIspita evidencija = EvidencijaIspita.getInstanca();
		System.out.print("Unesite broj indeksa: ");
		String brojIndeksa = Util.unesi();
		Student student = evidencija.preuzmiPoBrojuIndeksa(brojIndeksa);
		
		System.out.print("Unesite oznaku predmeta: ");
		String trazenaOznaka = Util.unesi();
		Predmet predmet = evidencija.preuzmiPredmetPoOznaci(trazenaOznaka);
		
		if (student != null && predmet != null) {
			Ispit ispit = student.getPolozeniIspit(predmet);
			ObrisiIspitStudenta komanda = new ObrisiIspitStudenta(evidencija, ispit, student);
			CommandManager.getInstance().izvrsi(komanda);
		} else {
			System.out.println("Nepostojeci student ili predmet");
		}
		
	}
}
