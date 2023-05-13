package vp.internet.konkurentnoprogramiranje;

public class Main {

	public static void main(String[] args) {
		System.out.println("Startovana main nit");
		for (int i = 0; i < 10; i++) {
			Nit n = new Nit(i);
			n.start();
		}
		System.out.println("Nit main zavrsila");
	}

}
