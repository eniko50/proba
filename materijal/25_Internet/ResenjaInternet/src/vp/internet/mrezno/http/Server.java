package vp.internet.mrezno.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.List;

public class Server {
	
	
	private void pokreni() {
		ServerSocket ss;
		try {
			ss = new ServerSocket(9100);
			System.out.println("Server pokrenut.");
			while (true) {
				System.out.println("Ocekuje povezivanje ...");

				Socket sock = ss.accept();
				
				System.out.println("Primljena veza ...");
					
				BufferedReader in = new BufferedReader(new InputStreamReader(
						sock.getInputStream()));
				
				PrintWriter out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(sock.getOutputStream())), true);
				
				String zahtev = in.readLine();
				
				obradiZahtev(out, zahtev);
				System.out.println("Vracen odgovor");
				in.close();
				out.close();
				sock.close();
			}	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void obradiZahtev(PrintWriter out, String zahtev) throws IOException { // stream u koji treba da upise odgovor
		System.out.println("Primljen zahtev: " + zahtev);
		
		String[] delovi = zahtev.split(" ");
		// ako je validan GET zahtev
		if (delovi.length == 3 && delovi[0].equals("GET") && 
				delovi[2].equals("HTTP/1.1")) {
			String resurs = delovi[1]; // preuzmemo koji resurs je trazen
			// ucitavanje resursa iz fajl sistema
			File f = new File("data/" + resurs);
			if (f.exists()) { // ako je ispravan resurs vracamo sadrzaj
				//zaglavlje
				out.println("HTTP/1.1 200 OK");
				out.println("Content-Type: text/html");
				out.println(); // prazna linija nakon zaglavlja
				// linije sadrzaja resursa
				
				List<String> sadrzajResursa = Files.readAllLines(f.toPath());
				for (String linija: sadrzajResursa) {
					out.println(linija);
				}
			} else { // ako je nepostojeci resurs vraca se greska
				out.println("HTTP/1.1 404 Not Found");
				System.out.println("Nepostojeci resurs trazen");
			}
		} else {
			// odgovor sa informacijom da je greska
			// HTTP status kod 400 znaci Bad request
			out.println("HTTP/1.1 400 Bad Request");
			System.out.println("Greska u formatu HTTP zahteva");
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.pokreni();
	}
}
