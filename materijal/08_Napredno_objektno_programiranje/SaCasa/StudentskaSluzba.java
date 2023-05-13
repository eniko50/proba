package vp04.termin8.obrada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import vp04.termin8.studenti.Student;

public class StudentskaSluzba {

	public static void main(String[] args) {
		Student[] studenti = new Student[100];
		studenti[0] = new Student("5463", "Petar", "Petrovic");
		studenti[1] = new Student("5333", "Marko", "Markovic");
		
		
		int ukupnoStudenata = 2;
		String opcija = null;
		do {
			
			
			System.out.println("==== Meni =====");
			System.out.println("1. Prikaz studenata");
			System.out.println("2. Pronadji studenta");
			
			
			System.out.print("Unesite opciju: ");
			
			// unos opcije - moglo bi se upakovati u metodu
			
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			try {
				opcija = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			switch (opcija) {
			case "1":
				for (int i = 0; i < ukupnoStudenata; i++) {
					System.out.println(studenti[i].getIme() + 
						" " + studenti[i].getPrezime() + 
						" " + studenti[i].getBrIndeksa());
				}
				break;
				
			case "3":
				System.out.print("Unesite indeks: ");
				String brIndeksa = unos();
				
				String ime = unos();
				String prezime = unos();
				Student novi = new Student(brIndeksa, ime, prezime);
				studenti[ukupnoStudenata++] = novi;
			}
		} while (!opcija.equals("6"));
	}
	static String unos() {
		String s = null;
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		try {
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}

}
