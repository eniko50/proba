package vp.polimorfizam;

import java.time.*;

public class Main {

	public static void main(String[] args) {
		//kreiranje korisnika
        Korisnik korisnik = new Korisnik("Marko", "Petrovic", 1);

        //kreiranje priznanice za januar
        Priznanica priznanicaJan = new Priznanica();
        priznanicaJan.setBrojRacuna("2256");
        priznanicaJan.setDatum(LocalDate.of(2016, Month.JANUARY, 8));
        priznanicaJan.setZaMesec("Januar");

        //kreiranje stavki
        StavkaGrejanje grejanjeJan = new StavkaGrejanje(68, 32);
        StavkaVoda vodaJan = new StavkaVoda(14, 4, 54, 1000);

        //dodavanje stavki u priznanicu
        priznanicaJan.getStavke().add(grejanjeJan);
        priznanicaJan.getStavke().add(vodaJan);

        //kreiranje priznanice za februar
        Priznanica priznanicaFeb = new Priznanica();
        priznanicaFeb.setBrojRacuna("3422");
        priznanicaFeb.setDatum(LocalDate.of(2016, Month.FEBRUARY, 4));
        priznanicaFeb.setZaMesec("Februar");

        //kreiranje stavki
        StavkaGrejanje grejanjeFeb = new StavkaGrejanje(68, 32);
        StavkaVoda vodaFeb = new StavkaVoda(14, 4, 54, 800);
        StavkaOdrzavanje odrzavanjeFeb = new StavkaOdrzavanje(200, 20);
        
        //dodavanje stavki u priznanicu
        priznanicaFeb.getStavke().add(grejanjeFeb);
        priznanicaFeb.getStavke().add(vodaFeb);
        priznanicaFeb.getStavke().add(odrzavanjeFeb);

        //dodavanje priznanica korisniku
        korisnik.getPriznanice().add(priznanicaJan);
        korisnik.getPriznanice().add(priznanicaFeb);

        //ispis
        for (Priznanica priznanica: korisnik.getPriznanice()) {
            System.out.println("Priznanica za mesec: " + priznanica.getZaMesec());
            for (StavkaPriznanice stavka: priznanica.getStavke()) {
				System.out.printf("\t %s: %.2f \n", stavka.getNaziv(),
						stavka.izracunajIznos());

				/*
				 * Da ne postoji late binding, moralo bi ovako 
				 
                if (stavka instanceof StavkaGrejanje) {
                	StavkaGrejanje grejanje = (StavkaGrejanje) stavka;
					System.out.printf("\t %s: %.2f \n", grejanje.getNaziv(),
							grejanje.izracunajIznos());
                } else if (stavka instanceof StavkaVoda) {
                	StavkaVoda voda = (StavkaVoda) stavka;
                	System.out.printf("\t %s: %.2f \n", voda.getNaziv(),
							voda.izracunajIznos());
                } else if (stavka instanceof StavkaOdrzavanje) {
                	StavkaOdrzavanje odrzavanje = (StavkaOdrzavanje) stavka;
                	System.out.printf("\t %s: %.2f \n", odrzavanje.getNaziv(),
							odrzavanje.izracunajIznos());
                }                
                */                
            }
        }
	}
}
