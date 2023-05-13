package vp.fajlovi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class KorisnickaImena {
	public static void main(String[] args) throws IOException {

		BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("src/vp/fajlovi/korisnici.txt"));
            outputStream = new PrintWriter(new FileWriter("src/vp/fajlovi/korisnickaImena.txt"));

            String l;
        	String[] korisnik;
            while ((l = inputStream.readLine()) != null) {
            	korisnik = l.split(",");//["Pera","Peric"]
            	//"PPeric"
            	outputStream.println(korisnik[0].substring(0,1)+korisnik[1]);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
	}
}
