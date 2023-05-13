package vp.naprednoobjektno.konstruktori;

class Main {

	public static void main(String[] args) {
		Krug k1 = new Krug();
		k1.poluprecnik = 5;
		System.out.println("Obim kruga k1 je: " + k1.izracunajObim());
		
		Krug k2 = new Krug(10);
		System.out.println("Obim kruga k2 je: " + k2.izracunajObim());
	}
}
