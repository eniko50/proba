package vp.nezavisnebiblioteke.studenti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EvidencijaIspita {
	private static ArrayList<Student> studenti = new ArrayList<>();
	private static ArrayList<Predmet> predmeti = new ArrayList<>();

	public void inicijalizujPodatke() {
		Student s = new Student("Petar", "Petrovic", "3453",
				LocalDate.parse("1997-03-05"), "Novi Sad", "Srbija");

		Predmet p = new Predmet("1", "Matematika", 6);
		predmeti.add(p);
		Ispit ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setPismeniBodovi(35);
		ispit.setUsmeniBodovi(20);
		s.dodajPolozeniIspit(ispit);

		p = new Predmet("2", "Fizika", 4);
		predmeti.add(p);
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setPismeniBodovi(70);
		ispit.setUsmeniBodovi(22);
		s.dodajPolozeniIspit(ispit);

		p = new Predmet("3", "Informatika", 8);
		predmeti.add(p);
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setPismeniBodovi(40);
		ispit.setUsmeniBodovi(27);
		s.dodajPolozeniIspit(ispit);

		p = new Predmet("4", "Sociologija", 2);
		predmeti.add(p);
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setPismeniBodovi(41);
		ispit.setUsmeniBodovi(25);
		s.dodajPolozeniIspit(ispit);

		p = new Predmet("5", "Statistika", 6);
		predmeti.add(p);
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setPismeniBodovi(50);
		ispit.setUsmeniBodovi(37);
		s.dodajPolozeniIspit(ispit);

		p = new Predmet("6", "Osnove racunara", 7);
		predmeti.add(p);
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setPismeniBodovi(60);
		ispit.setUsmeniBodovi(15);
		s.dodajPolozeniIspit(ispit);

		p = new Predmet("7", "Osnove elektrotehnike", 6);
		predmeti.add(p);
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setPismeniBodovi(50);
		ispit.setUsmeniBodovi(25);
		s.dodajPolozeniIspit(ispit);

		p = new Predmet("8", "Objektno programiranje", 8);
		predmeti.add(p);
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setPismeniBodovi(45);
		ispit.setUsmeniBodovi(20);
		s.dodajPolozeniIspit(ispit);

		p = new Predmet("9", "Veb programiranje", 6);
		predmeti.add(p);
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setPismeniBodovi(35);
		ispit.setUsmeniBodovi(30);
		s.dodajPolozeniIspit(ispit);

		p = new Predmet("10", "Racunarska inteligencija", 5);
		predmeti.add(p);
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setPismeniBodovi(42);
		ispit.setUsmeniBodovi(22);
		s.dodajPolozeniIspit(ispit);

		studenti.add(s);

		s = new Student("Marko", "Markovic", "2366",
				LocalDate.parse("1998-01-04"), "Beograd", "Srbija");
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setPismeniBodovi(57);
		ispit.setUsmeniBodovi(15);
		s.dodajPolozeniIspit(ispit);
		studenti.add(s);
	}

	public String unesi() {
		String unos = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			unos = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return unos;
	}

	public void prikaziStudente() {
		System.out.println("Studenti u evidenciji: ");
		for (Student s : studenti) {
			System.out.println(s);
		}
	}

	public void pronadjiStudenta() {
		Student trazeniStudent = preuzmiPoBrojuIndeksa();
		if (trazeniStudent != null) {
			System.out.print("Podaci trazenog studenta: ");
			System.out.println(trazeniStudent);
		} else {
			System.out.println("Trazeni student ne postoji");
		}
	}

	public Student preuzmiPoBrojuIndeksa() {
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

	public void dodajStudenta() {
		System.out.print("Unesite ime studenta: ");
		String unesenoIme = unesi();
		System.out.print("Unesite prezime studenta: ");
		String unesenoPrezime = unesi();
		System.out.print("Unesite broj indeksa studenta: ");
		String uneseniIndeks = unesi();

		System.out
				.print("Unesite datum rodjenja studenta (primer 03.09.1998.): ");
		String uneseniDatum = unesi();
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("dd.MM.yyyy.");
		LocalDate datum = LocalDate.parse(uneseniDatum, formatter);

		System.out.print("Unesite grad rodjenja: ");
		String uneseniGrad = unesi();
		System.out.print("Unesite drzavu rodjenja: ");
		String unesenaDrzava = unesi();

		Student noviStudent = new Student(unesenoIme, unesenoPrezime,
				uneseniIndeks, datum, uneseniGrad, unesenaDrzava);
		studenti.add(noviStudent);
	}

	public void izmeniStudenta() {
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

	public void obrisiStudenta() {
		Student studentZaBrisanje = preuzmiPoBrojuIndeksa();
		studenti.remove(studentZaBrisanje);
	}

	public void prikaziPredmete() {
		System.out.println("Predmeti u evidenciji: ");
		for (Predmet p : predmeti) {
			System.out.println(p);
		}
	}

	public void pronadjiPredmet() {
		Predmet trazeniPredmet = preuzmiPredmetPoOznaci();
		if (trazeniPredmet != null) {
			System.out.print("Podaci trazenog predmeta: ");
			System.out.println(trazeniPredmet);
		} else {
			System.out.println("Trazeni predmet ne postoji");
		}
	}

	public Predmet preuzmiPredmetPoOznaci() {
		System.out.print("Unesite oznaku predmeta: ");
		String trazenaOznaka = unesi();

		for (Predmet p : predmeti) {
			if (p.getOznaka().equals(trazenaOznaka)) {
				return p;
			}
		}
		return null;
	}

	public void dodajPredmet() {
		System.out.print("Unesite naziv predmeta: ");
		String uneseniNaziv = unesi();
		System.out.print("Unesite broj ESPB bodova za predmet: ");
		String uneseniBodovi = unesi();

		// oznaka predmeta se automatski dodeljuje
		Predmet noviPredmet = new Predmet(String.valueOf(predmeti.size() + 1),
				uneseniNaziv, Integer.valueOf(uneseniBodovi));
		predmeti.add(noviPredmet);
	}

	public void izmeniPredmet() {
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

	public void obrisiPredmet() {
		Predmet predmetZaBrisanje = preuzmiPredmetPoOznaci();
		predmeti.remove(predmetZaBrisanje);
	}

	public void dodajIspitStudenta() {
		// izaberemo studenta kojem evidentiramo novi ispit
		Student student = preuzmiPoBrojuIndeksa();
		// izaberemo predmet koji polaze
		Predmet predmet = preuzmiPredmetPoOznaci();

		if (student != null && predmet != null) {
			Ispit ispit = unesiIspit(predmet);
			student.dodajPolozeniIspit(ispit);
		} else {
			System.out.println("Nepostojeci student ili predmet");
		}
	}

	public Ispit unesiIspit(Predmet predmet) {
		Ispit ispit = new Ispit();
		System.out.print("Unesite bodove sa usmenog ispita: ");
		String usmeni = unesi();
		System.out.print("Unesite bodove sa pismenog ispita: ");
		String pismeni = unesi();
		ispit.setPredmet(predmet);
		ispit.setUsmeniBodovi(Integer.valueOf(usmeni));
		ispit.setPismeniBodovi(Integer.valueOf(pismeni));

		return ispit;
	}

	public void obrisiIspitStudenta() {
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
