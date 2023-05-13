package vp.naprednoobjektno.izuzeci;

public class Main3 {

	public static void main(String[] args) throws Exception {
		Test test = new Test();
		test.izvrsiSaPropagacijomIzuzetka();
		
		// ovo se nece izvrsiti, jer se pre toga desi izuzetak koji nije uhvacen
		System.out.println("Program izvrsen do kraja"); 
	}
}
