package vp.nezavisnebiblioteke.studenti;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EvidencijaIspita {
	private static ArrayList<Student> studenti = new ArrayList<>();
	private static ArrayList<Predmet> predmeti = new ArrayList<>();

	public static void main(String[] args) {
		inicijalizujPodatke();

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
				prebaciUExcel();
				break;
			case 14:
				podaciPdf();
				break;
			case 15:
				prebaciDetaljeUExcel();
				break;
			case 16:
				pdfSaSlikom();
				break;
			case 17:
				System.out.println("Hvala sto ste koristili program");
			default:
			}
		} while (opcija != 17);
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
		System.out.println("13. Eksport studenata u excel");
		System.out.println("14. PDF dokument o studentu");
		System.out.println("15. Eksport detalja studenata u excel");
		System.out.println("16. PDF dokument o studentu sa slikom");
		System.out.println("17. Izlaz");
	}

	private static void inicijalizujPodatke() {
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
			Ispit ispit = unesiIspit(predmet);
			student.dodajPolozeniIspit(ispit);
		} else {
			System.out.println("Nepostojeci student ili predmet");
		}
	}

	private static Ispit unesiIspit(Predmet predmet) {
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

	private static void prebaciUExcel() {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("Studenti");

		int brojReda = 0;

		Row row = sheet.createRow(brojReda++);

		Cell cell = row.createCell(0);
		cell.setCellValue("Broj indeksa");
		cell = row.createCell(1);
		cell.setCellValue("Ime");
		cell = row.createCell(2);
		cell.setCellValue("Prezime");

		for (Student s : studenti) {
			row = sheet.createRow(brojReda++);
			cell = row.createCell(0);
			cell.setCellValue(s.getBrIndeksa());
			cell = row.createCell(1);
			cell.setCellValue(s.getIme());
			cell = row.createCell(2);
			cell.setCellValue(s.getPrezime());
		}

		try {
			FileOutputStream fileOut = new FileOutputStream(
					"output/studenti.xlsx");
			wb.write(fileOut);
			fileOut.close();
			wb.close();
			System.out.println("Eksport uspesno izvrsen u fajl studenti.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static PDDocument kreirajPdfDokument(Student student)
			throws IOException {
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage(page);

		// Create a new font object selecting one of the PDF base fonts
		PDFont font = PDType1Font.HELVETICA_BOLD;

		// Start a new content stream which will "hold" the to be created
		// content
		PDPageContentStream contentStream;
		contentStream = new PDPageContentStream(document, page);
		// naslov
		contentStream.beginText();
		contentStream.setFont(font, 26);
		contentStream.newLineAtOffset(200, 720);
		contentStream.showText(student.getBrIndeksa() + " " + student.getIme()
				+ " " + student.getPrezime());
		contentStream.endText();

		// linija
		contentStream.moveTo(70, 700);
		contentStream.lineTo(560, 700);
		contentStream.stroke();

		// datum i mesto rodjenja
		contentStream.beginText();
		contentStream.setFont(font, 12);
		contentStream.newLineAtOffset(400, 680);
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("dd.MM.yyyy.");
		String datum = student.getDatumRodjenja().format(formatter);
		contentStream.showText(datum + " " + student.getGradRodjenja() + " "
				+ student.getDrzavaRodjenja());
		contentStream.endText();

		// ispiti
		int offset = 650;
		final int space = 15; // razmak izmedju redova

		contentStream.beginText();
		contentStream.setFont(font, 18);
		contentStream.newLineAtOffset(300, offset);
		contentStream.showText("Ispiti");
		contentStream.endText();

		contentStream.setFont(font, 12);
		// spisak ispita
		for (int i = 0; i < student.getIspiti().size(); i++) {
			Ispit ispit = student.getIspiti().get(i);

			offset -= space;

			// linija
			contentStream.moveTo(70, offset);
			contentStream.lineTo(560, offset);
			contentStream.stroke();

			offset -= space;

			// naziv ispita
			String naziv = ispit.getPredmet().getNaziv() + " ("
					+ ispit.getOcena() + ")";
			contentStream.beginText();
			contentStream.newLineAtOffset(295, offset);
			contentStream.showText(naziv);
			contentStream.endText();

			offset -= space;

			// bodovi pismeni
			contentStream.beginText();
			contentStream.newLineAtOffset(70, offset);
			contentStream.showText("Pismeni: " + ispit.getPismeniBodovi());
			contentStream.endText();

			offset -= space;

			// bodovi usmeni
			contentStream.beginText();
			contentStream.newLineAtOffset(70, offset);
			contentStream.showText("Usmeni: " + ispit.getUsmeniBodovi());
			contentStream.endText();

			offset -= space;

			// espb bodovi
			contentStream.beginText();
			contentStream.newLineAtOffset(500, offset);
			contentStream.showText("ESPB: " + ispit.getPredmet().getEspb());
			contentStream.endText();

			// kreiranje nove stranice po potrebi
			if (offset < 200) {

				// Make sure that the content stream is closed:
				contentStream.close();

				page = new PDPage();
				document.addPage(page);
				contentStream = new PDPageContentStream(document, page);
				contentStream.setFont(font, 12);

				offset = 720;
			}
		}
		offset -= space;

		// linija
		contentStream.moveTo(70, offset);
		contentStream.lineTo(560, offset);
		contentStream.stroke();

		offset -= space;

		// ukupno ispita
		contentStream.beginText();
		contentStream.newLineAtOffset(70, offset);
		contentStream.showText("Ukupno ispita: " + student.getIspiti().size());
		contentStream.endText();

		offset -= space;

		// prosecna ocena
		contentStream.beginText();
		contentStream.newLineAtOffset(70, offset);
		double prosek = student.izracunajProsek();
		DecimalFormat df = new DecimalFormat("0.00");
		String formatirano = df.format(prosek); // na dve decimale
		contentStream.showText("Prosecna ocena: " + formatirano);
		contentStream.endText();

		offset -= space;

		contentStream.beginText();
		contentStream.newLineAtOffset(70, offset);
		contentStream.showText("Ukupno ESPB: " + student.izracunajEspb());
		contentStream.endText();

		contentStream.close();

		return document;
	}

	private static void podaciPdf() {
		Student student = preuzmiPoBrojuIndeksa();
		try {
			PDDocument document = kreirajPdfDokument(student);
			snimiPdfDokument(document, "output/" + student.getBrIndeksa()
					+ ".pdf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void snimiPdfDokument(PDDocument document, String putanja)
			throws IOException {
		document.save(putanja);
		document.close();
	}

	private static void prebaciDetaljeUExcel() {
		XSSFWorkbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("Studenti");
		sheet.setDefaultColumnWidth(10);
		sheet.setColumnWidth(3, 8000);
		int brojReda = 0;

		Row row = sheet.createRow(brojReda++);

		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);

		CellStyle nonCenteredStyle = wb.createCellStyle();
		nonCenteredStyle.cloneStyleFrom(cellStyle);
		nonCenteredStyle.setAlignment(HorizontalAlignment.LEFT);

		// header cells style
		CellStyle headerStyle = wb.createCellStyle();
		headerStyle.cloneStyleFrom(cellStyle);
		headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT
				.getIndex());
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		// ukupno bodova stil
		CellStyle pointsStyle = wb.createCellStyle();
		pointsStyle.cloneStyleFrom(cellStyle);
		pointsStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		pointsStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		// prvi red
		Cell cell = row.createCell(0);
		cell.setCellValue("Broj indeksa");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(1);
		cell.setCellValue("Ime");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(2);
		cell.setCellValue("Prezime");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(3);
		cell.setCellValue("Ispiti");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(4);
		cell.setCellStyle(headerStyle);
		cell = row.createCell(5);
		cell.setCellStyle(headerStyle);
		cell = row.createCell(6);
		cell.setCellStyle(headerStyle);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 3, 6));

		// drugi red
		row = sheet.createRow(brojReda++);
		cell = row.createCell(0);
		cell.setCellStyle(headerStyle);
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));

		cell = row.createCell(1);
		cell.setCellStyle(headerStyle);
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 1));

		cell = row.createCell(2);
		cell.setCellStyle(headerStyle);
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 2, 2));

		cell = row.createCell(3);
		cell.setCellValue("Predmet");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(4);
		cell.setCellValue("Usmeni");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(5);
		cell.setCellValue("Pismeni");
		cell.setCellStyle(headerStyle);
		cell = row.createCell(6);
		cell.setCellValue("Ukupno");
		cell.setCellStyle(headerStyle);

		for (Student s : studenti) {
			for (int i = 0; i < s.getIspiti().size(); i++) {
				// broj reda ostaje da ukazuje na red na kojem pocinju podaci o
				// studentu
				sheet.createRow(brojReda + i);
			}
			row = sheet.getRow(brojReda);

			cell = row.createCell(0);
			cell.setCellValue(s.getBrIndeksa());
			cell.setCellStyle(cellStyle);

			cell = row.createCell(1);
			cell.setCellValue(s.getIme());
			cell.setCellStyle(cellStyle);

			cell = row.createCell(2);
			cell.setCellValue(s.getPrezime());
			cell.setCellStyle(cellStyle);

			if (s.getIspiti().size() > 1) {
				CellRangeAddress range = new CellRangeAddress(brojReda,
						brojReda + s.getIspiti().size() - 1, 0, 0);
				sheet.addMergedRegion(range);
				RegionUtil.setBorderRight(BorderStyle.THIN.ordinal(), range,
						sheet);

				range = new CellRangeAddress(brojReda, brojReda
						+ s.getIspiti().size() - 1, 1, 1);
				sheet.addMergedRegion(range);
				RegionUtil.setBorderRight(BorderStyle.THIN.ordinal(), range,
						sheet);

				range = new CellRangeAddress(brojReda, brojReda
						+ s.getIspiti().size() - 1, 2, 2);
				sheet.addMergedRegion(range);
				RegionUtil.setBorderRight(BorderStyle.THIN.ordinal(), range,
						sheet);
			}

			for (int i = 0; i < s.getIspiti().size(); i++) {
				Ispit ispit = s.getIspiti().get(i);
				Row ispitRow = sheet.getRow(brojReda + i);
				cell = ispitRow.createCell(3);
				cell.setCellValue(ispit.getPredmet().getNaziv());
				cell.setCellStyle(nonCenteredStyle);
				cell = ispitRow.createCell(4);
				cell.setCellValue(ispit.getUsmeniBodovi());
				cell.setCellStyle(cellStyle);
				cell = ispitRow.createCell(5);
				cell.setCellValue(ispit.getPismeniBodovi());
				cell.setCellStyle(cellStyle);
				cell = ispitRow.createCell(6);
				cell.setCellType(CellType.FORMULA);
				// formula npr. E3:F3
				// brojReda ide od nula, a u formuli indeksi idu od 1. Zato + 1
				cell.setCellFormula("SUM(E" + (brojReda + i + 1) + ":F"
						+ (brojReda + i + 1) + ")");
				cell.setCellStyle(pointsStyle);
			}
			brojReda += s.getIspiti().size(); // red na kojem pocinje sledeci
												// student
		}

		try {
			FileOutputStream fileOut = new FileOutputStream(
					"output/studenti_detalji.xlsx");
			wb.write(fileOut);
			fileOut.close();
			wb.close();
			System.out.println("Eksport uspesno izvrsen u fajl studenti.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void pdfSaSlikom() {
		Student student = preuzmiPoBrojuIndeksa();
		try {
			// iskoristimo funkciju koja kreira pdf dokument
			PDDocument document = kreirajPdfDokument(student);
			// u ovaj dokument dodamo sliku
			PDPage page = document.getPage(0);
			PDImageXObject pdImage = PDImageXObject.createFromFile(
					"data/" + student.getBrIndeksa() + ".jpg", document);
			PDPageContentStream contentStream = new PDPageContentStream(
					document, page, PDPageContentStream.AppendMode.APPEND, true);
			contentStream.drawImage(pdImage, 70, 710);
			contentStream.close();
			
			snimiPdfDokument(document, "output/" + student.getBrIndeksa()
					+ "_slika.pdf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
