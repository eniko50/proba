package vp.internet.mrezno.studenti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("127.0.0.1");
			String opcija;
			do {
				Socket sock = new Socket(address, 9100);
				
				BufferedReader in = new BufferedReader(new InputStreamReader(
						sock.getInputStream()));
				
				PrintWriter out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(sock.getOutputStream())), true);
				
				System.out.println("Izaberite jednu od opcija:");
				System.out.println("1. Spisak svih studenata");
				System.out.println("2. Pronalazenje studenta");
				System.out.println("3. Dodavanje studenta");
				System.out.println("4. Izmena studenta");
				System.out.println("5. Brisanje studenta");
				System.out.println("6. Izlaz");
				
				// unos opcije
				BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in));
				opcija = br.readLine();
				
				switch (opcija) {
					case "1":
						zatraziSpisakStudenata(in, out);
						break;
					case "2":
						zatraziPronalazenjeStudenta(in, out);
						break;
					case "3":
						zatraziDodavanjeStudenta(in, out);
						break;
					case "4":
						zatraziIzmenuStudenta(in, out);
						break;
					case "5":
						zatraziBrisanjeStudenta(in, out);
						break;
				}
				
				out.close();
				in.close();
				sock.close();
			} while (!opcija.equals("6"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void zatraziSpisakStudenata(BufferedReader in, PrintWriter out) throws IOException {
		out.println("list"); // slanje poruke serveru
		String odgovor = in.readLine();
		// split po delimiteru da odvojimo podatke o svakom studentu u poseban String
		String[] podaci = odgovor.split(";"); 
		System.out.println("Spisak studenata");
		for (String p: podaci) {
			System.out.println(p);
		}
	}
	
	private static void zatraziPronalazenjeStudenta(BufferedReader in, PrintWriter out) throws IOException {
		// korisnik unosi kojeg studenta zeli da pronadje
		System.out.println("Molimo unesite broj indeksa studenta kojeg trazite");
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		String brIndeksa = br.readLine();
		
		out.println("find " + brIndeksa); // slanje poruke serveru
		String odgovor = in.readLine();
		System.out.println(odgovor);
	}
	
	private static void zatraziDodavanjeStudenta(BufferedReader in, PrintWriter out) throws IOException {
		// unos podataka o studentu
		System.out.println("Molimo unesite podatke o studentu");
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.print("Broj indeksa: ");
		String brIndeksa = br.readLine();
		System.out.print("Ime: ");
		String ime = br.readLine();
		System.out.println("Prezime");
		String prezime = br.readLine();
		// protokol pri dodavanju je add <brIndeksa> <ime> <prezime>
		// npr. add 2636 Marko Markovic
		out.println("add " + brIndeksa + " " + ime + " " + prezime); // slanje poruke serveru
		String odgovor = in.readLine();
		// split po delimiteru da odvojimo podatke o svakom studentu u poseban String
		if (odgovor.equals("ok")) {
			System.out.println("Student je uspesno dodat.");
		} else {
			System.out.println("Nije uspelo dodavanje studenta.");
		}
	}
	
	private static void zatraziBrisanjeStudenta(BufferedReader in, PrintWriter out) throws IOException {
		// korisnik unosi kojeg studenta zeli da obrise
		System.out.println("Molimo unesite broj indeksa studenta kojeg zelite da obrisete");
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		String brIndeksa = br.readLine();
		
		out.println("delete " + brIndeksa); // slanje poruke serveru
		String odgovor = in.readLine();
		if (odgovor.equals("ok")) {
			System.out.println("Student je obrisan.");
		} else {
			System.out.println("Nije uspelo brisanje studenta.");
		}
	}
	
	private static void zatraziIzmenuStudenta(BufferedReader in, PrintWriter out) throws IOException {
		// unos podataka o studentu
		System.out.println("Molimo unesite broj indeksa studenta cije podatke menjate");
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.print("Broj indeksa: ");
		String brIndeksa = br.readLine();
		
		System.out.println("Sada unesite izmenjene podatke");
		System.out.print("Izmenjeno ime: ");
		String ime = br.readLine();
		System.out.println("Izmenjeno prezime");
		String prezime = br.readLine();
		// protokol pri dodavanju je modify <brIndeksa> <ime> <prezime>
		// npr. edit 2636 Marko Markovic
		out.println("modify " + brIndeksa + " " + ime + " " + prezime); // slanje poruke serveru
		String odgovor = in.readLine();
		// split po delimiteru da odvojimo podatke o svakom studentu u poseban String
		if (odgovor.equals("ok")) {
			System.out.println("Student je uspesno izmenjen.");
		} else {
			System.out.println("Nije uspela izmena studenta.");
		}
	}
}
