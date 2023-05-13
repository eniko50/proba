package vp.uml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EvidencijaIspita {
	private static ArrayList<Student> studenti = new ArrayList<>();
	private static ArrayList<Predmet> predmeti = new ArrayList<>();
	private static ArrayList<Korisnik> korisnici = new ArrayList<>();

	public static void main(String[] args) {
		// definisemo neke korisnike sistema
		TipKorisnika tk1 = new TipKorisnika(1, "administrator");
		TipKorisnika tk2 = new TipKorisnika(1, "referent");		
		Korisnik k1 = new Korisnik("admin", "12345", "Petar", "Petrovic", tk1);
		Korisnik k2 = new Korisnik("marko", "2017", "Marko", "Markovic", tk2);
		korisnici.add(k1);
		korisnici.add(k2);
		
		Korisnik ulogovan = null;
		while ( (ulogovan = login()) == null) { //izvrsavaj funkciju za logovanje dok god se uspesno ne uloguje			
		}

		int opcija = 0;

		do {
			// unos opcije
			prikaziMeni(ulogovan);
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
				if (ulogovan.getTipKorisnika().getNaziv().equals("administrator")) {
					prikaziPredmete();
				} else {
					System.out.println("Ova opcija je dostupna samo administratoru");
				}
				break;
			case 7:
				if (ulogovan.getTipKorisnika().getNaziv().equals("administrator")) {
					pronadjiPredmet();
				} else {
					System.out.println("Ova opcija je dostupna samo administratoru");
				}	 				
				break;
			case 8:
				if (ulogovan.getTipKorisnika().getNaziv().equals("administrator")) {
					dodajPredmet();
				} else {
					System.out.println("Ova opcija je dostupna samo administratoru");
				}
				break;
			case 9:
				if (ulogovan.getTipKorisnika().getNaziv().equals("administrator")) {
					izmeniPredmet();
				} else {
					System.out.println("Ova opcija je dostupna samo administratoru");
				}
				break;
			case 10:
				if (ulogovan.getTipKorisnika().getNaziv().equals("administrator")) {
					obrisiPredmet();
				} else {
					System.out.println("Ova opcija je dostupna samo administratoru");
				}
				break;
			case 11:
				dodajIspitStudenta();
				break;
			case 12:
				obrisiIspitStudenta();
				break;
			case 13:
				System.out.println("Hvala sto ste koristili program");
			default:
			}
		} while (opcija != 13);
	}
	
	private static Korisnik login() {
		System.out.print("Korisnicko ime:");
		String korisnickoIme = unesi();
		System.out.print("Lozinka:");
		String lozinka = unesi();
		
		Korisnik korisnik = null;
		for (Korisnik k: korisnici) {
			if (k.getKorisnickoIme().equals(korisnickoIme) && 
					k.getLozinka().equals(lozinka)) {
				korisnik = k;
				break;
			}
		}
		
		if (korisnik == null) {
			System.out.println("Neispravno korisnicko ime ili lozinka");
		}
		
		return korisnik;

	}

	private static void prikaziMeni(Korisnik ulogovan) {
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
		System.out.println("13. Izlaz");
	}

	private static String unesi() {
		String unos = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			unos = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return unos;
	}

	private static void prikaziStudente() {
		System.out.println("Studenti u evidenciji: ");
		for (Student s : studenti) {
			System.out.println(s);
		}
	}

	private static void pronadjiStudenta() {
		Student trazeniStudent = preuzmiPoBrojuIndeksa();
		if (trazeniStudent != null) {
			System.out.print("Podaci trazenog studenta: ");
			System.out.println(trazeniStudent);
		} else {
			System.out.println("Trazeni student ne postoji");
		}
	}

	private static Student preuzmiPoBrojuIndeksa() {
		// unos broja indeksa
		System.out.print("Unesite broj indeksa: ");
		String trazeniIndeks = unesi();

		for (Student s : studenti) {
			if (s.getBrIndeksa().equals(trazeniIndeks)) {
				return s;
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
		
		System.out.print("Unesite datum rodjenja studenta (primer 03.09.1998.): ");
		String uneseniDatum = unesi();		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");		
		LocalDate datum = LocalDate.parse(uneseniDatum, formatter);
		
		System.out.print("Unesite grad rodjenja: ");
		String uneseniGrad = unesi();
		System.out.print("Unesite drzavu rodjenja: ");
		String unesenaDrzava = unesi();

		Student noviStudent = new Student(unesenoIme, unesenoPrezime,
				uneseniIndeks, datum, uneseniGrad, unesenaDrzava);
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
		studenti.remove(studentZaBrisanje);
	}

	private static void prikaziPredmete() {
		System.out.println("Predmeti u evidenciji: ");
		for (Predmet p : predmeti) {
			System.out.println(p);
		}
	}

	private static void pronadjiPredmet() {
		Predmet trazeniPredmet = preuzmiPredmetPoOznaci();
		if (trazeniPredmet != null) {
			System.out.print("Podaci trazenog predmeta: ");
			System.out.println(trazeniPredmet);
		} else {
			System.out.println("Trazeni predmet ne postoji");
		}
	}

	private static Predmet preuzmiPredmetPoOznaci() {
		System.out.print("Unesite oznaku predmeta: ");
		String trazenaOznaka = unesi();

		for (Predmet p : predmeti) {
			if (p.getOznaka().equals(trazenaOznaka)) {
				return p;
			}
		}
		return null;
	}

	private static void dodajPredmet() {
		System.out.print("Unesite naziv predmeta: ");
		String uneseniNaziv = unesi();
		System.out.print("Unesite broj ESPB bodova za predmet: ");
		String uneseniBodovi = unesi();

		// oznaka predmeta se automatski dodeljuje
		Predmet noviPredmet = new Predmet(String.valueOf(predmeti.size() + 1),
				uneseniNaziv, Integer.valueOf(uneseniBodovi));
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
		predmeti.remove(predmetZaBrisanje);
	}

	private static void dodajIspitStudenta() {
		// izaberemo studenta kojem evidentiramo novi ispit
		Student student = preuzmiPoBrojuIndeksa();
		// izaberemo predmet koji polaze
		Predmet predmet = preuzmiPredmetPoOznaci();

		if (student != null && predmet != null) {
			System.out.print("Unesite tip ispita (1 - standardan, "
					+ "2 - usmeno-pismeni, 3 - kolokvijumski: ");
			String tipIspita = unesi();
			Ispit ispit = unesiIspit(tipIspita, predmet);
			student.dodajPolozeniIspit(ispit);
		} else {
			System.out.println("Nepostojeci student ili predmet");
		}
	}

	private static Ispit unesiIspit(String tipIspita, Predmet predmet) {
		Ispit ispit = null;
		switch (tipIspita) {
		case "1":
			ispit = new Ispit();
			System.out.print("Unesite ocenu: ");
			String ocena = unesi();
			ispit.setPredmet(predmet);
			ispit.setOcena(Integer.valueOf(ocena));
			break;
		case "2":
			ispit = new UsmenoPismeniIspit();
			System.out.print("Unesite bodove sa usmenog ispita: ");
			String usmeni = unesi();
			System.out.print("Unesite bodove sa pismenog ispita: ");
			String pismeni = unesi();
			ispit.setPredmet(predmet);
			((UsmenoPismeniIspit) ispit).setUsmeniBodovi(Integer
					.valueOf(usmeni));
			((UsmenoPismeniIspit) ispit).setPismeniBodovi(Integer
					.valueOf(pismeni));
			break;
		case "3":
			ispit = new KolokvijumskiIspit();
			ispit.setPredmet(predmet);
			String unos;
			do {
				System.out.print("Unesite bodove sa kolokvijuma: ");
				String bodovi = unesi();
				System.out.print("Unesite datum kolokvijuma: ");
				String uneseniDatum = unesi();		
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");		
				LocalDate datum = LocalDate.parse(uneseniDatum, formatter);
				
				((KolokvijumskiIspit)ispit).dodajKolokvijum(datum,
						Integer.valueOf(bodovi));
				
				System.out.println("Da li ima jos kolokvijuma za unos (d/n)?");
				unos = unesi();

			} while (!unos.equals("n"));
			break;
		}
		return ispit;
	}

	private static void obrisiIspitStudenta() {
		// izaberemo studenta kojem brisemo ispit
		Student student = preuzmiPoBrojuIndeksa();
		// izaberemo ispit koji brisemo
		Predmet predmet = preuzmiPredmetPoOznaci();
		if (student != null && predmet != null) {
			student.obrisiPolozeniIspit(predmet);
		} else {
			System.out.println("Nepostojeci student ili predmet");
		}
	}
}
