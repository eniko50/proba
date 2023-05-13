package vp.ciklusiinizovi;

public class Bankomat {
	public static void main(String args[]) {
		int v = 10350;
		
		while (v > 0) {
			if (v >= 1000) {
				v -= 1000;
				System.out.println("Isplacujem 1000");
			} else if (v >= 500) {
				v -= 500;
				System.out.println("Isplacujem 500");
			} else if (v >= 200) {
				v -= 200;
				System.out.println("Isplacujem 200");
			} else if (v >= 100) {
				v -= 100;
				System.out.println("Isplacujem 100");
			} else if (v >=50) {
				v -= 50;
				System.out.println("Isplacujem 50");
			}
		}
	}
}
