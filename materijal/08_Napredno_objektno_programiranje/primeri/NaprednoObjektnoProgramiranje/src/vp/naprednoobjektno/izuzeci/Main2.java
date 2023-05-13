package vp.naprednoobjektno.izuzeci;

public class Main2 {

	public static void main(String[] args) {
		try {
			Test test = new Test();
			test.izvrsiSaPropagacijomIzuzetka();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Program izvrsen do kraja");
	}
}
