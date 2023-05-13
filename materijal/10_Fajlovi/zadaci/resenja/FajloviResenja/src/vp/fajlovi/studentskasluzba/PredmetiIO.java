package vp.fajlovi.studentskasluzba;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PredmetiIO {
	private static String putanja = "src/vp/fajlovi/studentskasluzba/predmeti.txt";

	private static Predmet string2Predmet(String red) {
		String[] s = red.split(",");
		Predmet retVal = new Predmet(s[0], s[1], Integer.parseInt(s[2]), Boolean.parseBoolean(s[3]));
		return retVal;
	}

	private static String predmet2String(Predmet predmet) {
		return predmet.getOznaka() + "," + predmet.getNaziv() + "," + predmet.getEspb()
				+ "," + predmet.isObrisan();
	}

	public static ArrayList<Predmet> ucitajPredmete() throws IOException {
		BufferedReader inputStream = null;
		ArrayList<Predmet> predmeti = null;
		try {
			inputStream = new BufferedReader(new FileReader(putanja));
			predmeti = new ArrayList<Predmet>();
            String l;
			while ((l = inputStream.readLine()) != null) {
				predmeti.add(string2Predmet(l));
			}
			return predmeti;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
	
	public static void snimiPredmete(List<Predmet> predmeti) throws IOException{
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileWriter(putanja));
			for (int i = 0; i < predmeti.size(); i++) {
				outputStream.println(predmet2String(predmeti.get(i)));
			}
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}
		
	}

}
