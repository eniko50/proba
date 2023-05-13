package vp.internet.mrezno.studenti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aplikacija {
	
	private static EvidencijaStudenata evidencija = new EvidencijaStudenata();
	
	public static void main(String[] args) {
		
		String opcija = "";
		do {
			System.out.println("Izaberite jednu od opcija:");
			System.out.println("1. Spisak svih studenata");
			System.out.println("2. Pronalazenje studenta");
			System.out.println("3. Dodavanje studenta");
			System.out.println("4. Izmena studenta");
			System.out.println("5. Brisanje studenta");
			System.out.println("6. Izlaz");
			
			// unos opcije
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				opcija = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
			
			switch (opcija) {
				case "1":
					ispisiStudente();
					break;
				case "2":
					pronadjiStudenta();
					break;
				case "3":
					dodavanjeStudenta();
					break;
				case "4":
					izmenaStudenta();
					break;
				case "5":
					brisanjeStudenta();
					break;
			}
		} while (!opcija.equals("6"));

	}
	
	private static void ispisiStudente() {
		System.out.println("Spisak studenata");
		evidencija.ispisiStudente();
	}
	
	private static void pronadjiStudenta() {
		System.out.println("Molimo unesite broj indeksa studenta kojeg trazite");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String brIndeksa = null;
		try {
			 brIndeksa = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Student student = evidencija.getStudent(brIndeksa);
		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("Student nije pronadjen.");
		}
	}
	
	private static void dodavanjeStudenta() {
		boolean uspesno = false;
		try {
			System.out.println("Molimo unesite podatke o studentu");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Broj indeksa: ");
			String brIndeksa = br.readLine();
			System.out.print("Ime: ");
			String ime = br.readLine();
			System.out.println("Prezime: ");
			String prezime = br.readLine();
			
			uspesno = evidencija.dodajStudenta(brIndeksa, ime, prezime);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (uspesno) {
			System.out.println("Student je uspesno dodat.");
		} else {
			System.out.println("Nije uspelo dodavanje studenta.");
		}
	}
	
	private static void brisanjeStudenta() {
		boolean uspesno = false;
		
		try {
			System.out.println("Molimo unesite broj indeksa studenta kojeg zelite da obrisete");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String brIndeksa = br.readLine();
			
			uspesno = evidencija.obrisiStudenta(brIndeksa);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (uspesno) {
			System.out.println("Student je obrisan.");
		} else {
			System.out.println("Nije uspelo brisanje studenta.");
		}
	}
	
	private static void izmenaStudenta() {
		boolean uspesno = false;
		try {
			System.out.println("Molimo unesite broj indeksa studenta cije podatke menjate");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Broj indeksa: ");
			String brIndeksa = br.readLine();
			
			System.out.println("Sada unesite izmenjene podatke");
			System.out.print("Izmenjeno ime: ");
			String ime = br.readLine();
			System.out.println("Izmenjeno prezime: ");
			String prezime = br.readLine();
			
			uspesno = evidencija.izmeniStudenta(brIndeksa, ime, prezime);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (uspesno) {
			System.out.println("Student je uspesno izmenjen.");
		} else {
			System.out.println("Nije uspela izmena studenta.");
		}
	}

}