package vp.fajlovi.studentskasluzba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentskaSluzba {
	private static List<Student> studenti;
	private static List<Predmet> predmeti;
	
	public static void main(String[] args) throws IOException {
		predmeti = PredmetiIO.ucitajPredmete();
		studenti = StudentiIO.ucitajStudente(predmeti);
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
				pronalazenjeStudenataPoProseku();
				break;
			case 14:
				snimanjePodataka();
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
		System.out.println("13. Pronalazenje studenata po proseku");
		System.out.println("14. Izlaz");
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
				System.out.println(studenti.get(i).toString());
			}
		}
	}
	
	private static void pronadjiStudenta() {
		Student trazeniStudent = preuzmiPoBrojuIndeksa();
		if (trazeniStudent != null) {
			System.out.print("Podaci trazenog studenta: ");
			System.out.println(trazeniStudent.toString());
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

	private static List<Student> preuzmiPoProseku() {
		List<Student> retVal = new ArrayList<Student>();
		System.out.print("Unesite donju granicu proseka prosek: ");
		double prosek = Double.parseDouble(unesi()); 
		for (int i = 0; i < studenti.size(); i++) {
			if (studenti.get(i).getProsek() >= prosek &&
					!studenti.get(i).isObrisan()) {
				retVal.add(studenti.get(i));
			}
		}
		return retVal;
	}
	
	//preuzimanje ocene sa tastature
	private static int preuzmiOcenu(){
		System.out.print("Unesite ocenu: ");
		String ocena = unesi(); 
		while (!(ocena.equals("6")||ocena.equals("7")||ocena.equals("8")||
				ocena.equals("9")||ocena.equals("10"))) {
			System.out.print("Nevalidan unos!\nUnesite ocenu: ");
			ocena = unesi(); 
			
		}
		return Integer.parseInt(ocena);
		
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
			studentZaBrisanje.setObrisan(true);
		}
	}
	
	private static void prikaziPredmete() {
		System.out.println("Predmeti u evidenciji: ");
		for (int i = 0; i < studenti.size(); i++) {
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
		
		Predmet noviPredmet = new Predmet(String.valueOf(predmeti.size()+1), 
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
		if (predmetZaBrisanje != null) {
			predmetZaBrisanje.setObrisan(true);
		}
	}
	
	private static void dodajIspitStudenta() {
		// izaberemo studenta kojem evidentiramo novi ispit
		Student student = preuzmiPoBrojuIndeksa();
		//izaberemo predmet koji polaze
		Predmet predmet = preuzmiPredmetPoOznaci();
		int ocena = preuzmiOcenu();
		if (student != null && predmet != null) {
			Ispit ispit = new Ispit(predmet, ocena);
			student.dodajPolozeniIspit(ispit);
		} else {
			System.out.println("Nepostojeci student ili predmet");
		}
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
	
	private static void pronalazenjeStudenataPoProseku(){
		// izaberemo studenta kojem brisemo ispit
		List<Student> studentiSaProsekom = preuzmiPoProseku();
		System.out.println("Studenti sa prosekom vecim od zadatog su: ");
		for (Student student : studentiSaProsekom) {
			System.out.println(student);
		}
	}
	
	private static void snimanjePodataka() throws IOException{
		PredmetiIO.snimiPredmete(predmeti);
		StudentiIO.snimiStudente(studenti);
	}
}
