package vp.naprednoobjektno.statickeklase;

class Main {

	public static void main(String[] args) {
		int rez = MatematickeOperacije.kvadriraj(5);
		System.out.println(rez);
		
		System.out.println(MatematickeOperacije.brojPoziva);
		
		Krug k = new Krug();
		k.poluprecnik = 5;
		System.out.println("Obim je: " + k.izracunajObim());
	}

}
