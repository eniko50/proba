package vp.ds.ispiti;

public class Aplikacija {

	public static void main(String[] args) {
		EvidencijaIspita evidencija = EvidencijaIspita.getInstanca();
		int opcija = 0;

		do {
			prikaziMeni();
			System.out.println("\nUnesite opciju: ");
			String opcijaTekst = Util.unesi();
			opcija = Integer.parseInt(opcijaTekst);

			switch (opcija) {
			case 1:
				evidencija.prikaziStudente();
				break;
			case 2:
				evidencija.pronadjiStudenta();
				break;
			case 3:
				evidencija.dodajStudenta();
				break;
			case 4:
				evidencija.izmeniStudenta();
				break;
			case 5:
				evidencija.obrisiStudenta();
				break;
			case 6:
				evidencija.prikaziPredmete();
				break;
			case 7:
				evidencija.pronadjiPredmet();
				break;
			case 8:
				evidencija.dodajPredmet();
				break;
			case 9:
				evidencija.izmeniPredmet();
				break;
			case 10:
				evidencija.obrisiPredmet();
				break;
			case 11:
				evidencija.dodajIspitStudenta();
				break;
			case 12:
				evidencija.obrisiIspitStudenta();
				break;
			case 13: 
				evidencija.pronadjiStudentePoProseku(); 
				break;
			 case 14:
				evidencija.ponisti();
				break;
			case 15:
				System.out.println("Hvala sto ste koristili program");
			default:
			}
		} while (opcija != 15);
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
		System.out.println("13. Pronalazak studenata po proseku");
		System.out.println("14. Ponisti");
		System.out.println("15. Izlaz");
	}
}
