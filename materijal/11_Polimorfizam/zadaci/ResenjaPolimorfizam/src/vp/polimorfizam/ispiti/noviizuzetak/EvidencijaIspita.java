package vp.polimorfizam.ispiti.noviizuzetak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EvidencijaIspita {
	private static ArrayList<Student> studenti = new ArrayList<>();
	private static ArrayList<Predmet> predmeti = new ArrayList<>();

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

		Student noviStudent = new Student(unesenoIme, unesenoPrezime,
				uneseniIndeks);
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
			if (ispit != null) {
				student.dodajPolozeniIspit(ispit);
			} {
				System.out.println("Neispravan unos. Ispit nije dodan.");
			}
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
			try {
				((UsmenoPismeniIspit) ispit).setUsmeniBodovi(Integer
						.valueOf(usmeni));
				((UsmenoPismeniIspit) ispit).setPismeniBodovi(Integer
						.valueOf(pismeni));
			} catch (InvalidExamPointsException e) {
				System.out.println("Ukupan broj bodova (" + e.getPoints() + 
						" nije ispravan.");
				return null;
			}
			break;
		case "3":
			ispit = new KolokvijumskiIspit();
			ispit.setPredmet(predmet);
			String unos;
			do {
				System.out.print("Unesite bodove sa kolokvijuma (x za prekid): ");
				unos = unesi();
				if (!unos.equals("x")) {
					try {
						((KolokvijumskiIspit)ispit).dodajKolokvijum(
								Integer.valueOf(unos));
					} catch (InvalidExamPointsException e) {
						System.out.println("Ukupan broj bodova (" + e.getPoints() + 
								") nije ispravan.");
						return null;
					}
				}
			} while (!unos.equals("x"));
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
