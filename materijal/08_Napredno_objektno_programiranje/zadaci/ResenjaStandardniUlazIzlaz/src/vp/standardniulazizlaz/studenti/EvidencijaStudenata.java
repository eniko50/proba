package vp.standardniulazizlaz.studenti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvidencijaStudenata {
	private static Student[] studenti = new Student[100];
	private static int ukupnoStudenata = 0;
	
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
				System.out.println("Hvala sto ste koristili program");
			default:
			}
		} while (opcija != 6);

	}
	
	private static void prikaziMeni() {
		System.out.println("1. Prikaz svih studenata");
		System.out.println("2. Pronalazenje studenta");
		System.out.println("3. Unos studenta");
		System.out.println("4. Izmena studenta");
		System.out.println("5. Brisanje studenta");
		System.out.println("6. Izlaz");
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
		for (int i = 0; i < ukupnoStudenata; i++) {
			if (!studenti[i].isObrisan()) {
				studenti[i].ispisiStudenta();
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
		
		for (int i = 0; i < ukupnoStudenata; i++) {
			if (studenti[i].getBrIndeksa().equals(trazeniIndeks) &&
					!studenti[i].isObrisan()) {
				return studenti[i];
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
		studenti[ukupnoStudenata++] = noviStudent; 
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
}
