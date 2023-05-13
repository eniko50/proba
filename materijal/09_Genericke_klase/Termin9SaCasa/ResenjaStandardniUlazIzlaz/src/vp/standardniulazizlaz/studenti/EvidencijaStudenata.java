package vp.standardniulazizlaz.studenti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import vp.standardniulazizlaz.predmeti.Predmet;

public class EvidencijaStudenata {
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
			case 11:
				dodavanjeIspita();
			case 12:
				System.out.println("Hvala sto ste koristili program");
			default:
			}
		} while (opcija != 12);

	}
	
	private static void prikaziMeni() {
		System.out.println("1. Prikaz svih studenata");
		System.out.println("2. Pronalazenje studenta");
		System.out.println("3. Unos studenta");
		System.out.println("4. Izmena studenta");
		System.out.println("5. Brisanje studenta");
		System.out.println("6. Prikaz svih predmeta");
		System.out.println("11. Dodavanje ispita");
		System.out.println("12. Izlaz");
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
			// studentZaBrisanje.setObrisan(true); // logicko brisanje
			studenti.remove(studentZaBrisanje);
		}
	}
	
	private static void prikaziPredmete() {
		System.out.println("Predmeti u evidenciji:");
		for (int i = 0; i < predmeti.size(); i++) {
			predmeti.get(i).ispisiPredmet();
		}
	}
	
	private static void dodavanjeIspita() {
		Student student = preuzmiPoBrojuIndeksa();
		System.out.print("Unesite ocenu: ");
		String unesenaOcena = unesi();
		int o = Integer.parseInt(unesenaOcena); 
		
		Predmet p = preuzmiPredmetPoOznaci();
		
		Ispit i = new Ispit(o, p);
		student.dodajIspit(i);
	}
	
	private static Predmet preuzmiPredmetPoOznaci() {
		System.out.println("Unesite oznaku predmeta: ");
		String oznaka = unesi();
		
		for (int i = 0; i < predmeti.size(); i++) {
			if (predmeti.get(i).getOznaka().equals(oznaka)) {
				return predmeti.get(i);
			}
		}
		return null;
	}
	
}
