package vp.naprednoobjektno.izuzeci;

public class Main1 {

	public static void main(String[] args) {
		Test test = new Test();
		test.izvrsiSaObradomIzuzetka();
		
		System.out.println(test.hashCode());
		
		System.out.println("Program izvrsen do kraja");
	}
}
