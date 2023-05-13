package vp04.filmovi;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import vp04.filmovi.model.Film;
import vp04.filmovi.model.Zanr;

public class Evidencija {
	
	private static List<Film> filmovi = new ArrayList<>();
	private static List<Zanr> zanrovi = new ArrayList<>();
	
	
	
	public static void main(String[] args) {
		Zanr z1 = new Zanr("h", "Horor");
		Zanr z2 = new Zanr("k", "Komedija");
		Zanr z3 = new Zanr("t", "Triler");
		zanrovi.add(z1);
		zanrovi.add(z2);
		zanrovi.add(z3);
		
		String opcija = null;
		
		
		do {
			meni();
			System.out.print("Unesite opciju: ");
			
			opcija = unesi();
			
			switch (opcija) {
			case "1":
				unosFilma();
				break;
			case "2":
				prikazFilmova();
				break;
			case "3":
				pretragaPoZanru();
				break;
			case "4":
				snimiUFajl();
				break;
			}
			
		} while (!opcija.equals("6"));
		
	}
	
	private static void meni() {
		System.out.println("1. Unos novog filma");
		System.out.println("2. Prikaz filmova");
		System.out.println("3. Pretraga po zanru");
		System.out.println("4. Snimanje u fajl");
		System.out.println("6. Izlaz");
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
	
	private static void unosFilma() {
		System.out.print("Unesite naziv filma: ");
		String uneseniNaziv = unesi();
		System.out.print("Unesite godinu filma: ");
		int unesenaGodina = Integer.parseInt(unesi());
		System.out.println("Unesite oznaku zanra: ");
		String unesenaOznakaZanra = unesi();
		
		// pronalazenje zanra
		Zanr nadjeniZanr = null;
		for (Zanr z : zanrovi) {
			if (z.getOznaka().equals(unesenaOznakaZanra)) {
				nadjeniZanr = z;
				break;
			} 
		}
		
		String id = String.valueOf(filmovi.size() + 1);
		
		Film f = new Film(id, uneseniNaziv, unesenaGodina, nadjeniZanr);
		filmovi.add(f);
	}
	
	private static void prikazFilmova() {
		System.out.println("Filmovi u evidenciji:");
		for (Film f : filmovi) {
			System.out.println(f);
		}
	}
	
	private static void pretragaPoZanru() {
		System.out.print("Unesite oznaku zanra: ");
		String uneseniZanr = unesi();
		for (Film f: filmovi) {
			if (f.getZanr().getOznaka().equals(uneseniZanr)) {
				System.out.println(f);
			}
		}
	}
	
	private static void snimiUFajl() {
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(new FileWriter("filmovi.txt"));
			
			System.out.print("Unesite pocetnu godinu: ");
			int pocetnaGodina = Integer.parseInt(unesi());
			System.out.print("Unesite krajnju godinu: ");
			int krajnjaGodina = Integer.parseInt(unesi());
			
			pw.println("Filmovi izdati od " + pocetnaGodina + 
					" do " + krajnjaGodina);
			int brojac = 1;
			for (Film f: filmovi) {
				if (f.getGodina() > pocetnaGodina && f.getGodina() < krajnjaGodina) {
					pw.println(brojac + ". " + f.getNaziv());
					brojac++;
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.close();
	}
	
	
	
	
	
	

}
