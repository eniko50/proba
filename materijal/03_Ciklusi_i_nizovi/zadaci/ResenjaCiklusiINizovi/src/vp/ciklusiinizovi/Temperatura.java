package vp.ciklusiinizovi;

public class Temperatura {
	public static void main(String[] args) {
		double temperaturaC = 27;
		String tipKonverzije = args[0]; // prvi argument iz niza argumenata je tip konverzije
		
		switch (tipKonverzije) {
		case "Farenhajt": 
			double temperaturaF = temperaturaC * 1.8 + 32;
			System.out.println("Temperatura u farenhajtima: " + temperaturaF);
			break;
		case "Kelvin":
			double temperaturaK = temperaturaC + 273.15;
			System.out.println("Temperatura u kelvinima: " + temperaturaK);
			break;
		}
	}
}
