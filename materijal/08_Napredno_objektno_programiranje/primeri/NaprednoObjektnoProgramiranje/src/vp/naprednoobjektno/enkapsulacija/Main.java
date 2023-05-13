package vp.naprednoobjektno.enkapsulacija;

public class Main {

	public static void main(String[] args) {
		Krug k = new Krug(10);
		System.out.println("Obim kruga je: " + k.izracunajObim());
		
		// double r = k.poluprecnik(); // greska pri kompajliranju 
		double r = k.getPoluprecnik();
		System.out.println("Poluprecnik kruga je: " + r);
		
		k.setPoluprecnik(5);
		System.out.println("Novi poluprecnik kruga je: " + r);
	}
}
