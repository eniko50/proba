package vp.ciklusiinizovi;

public class PonavljanjeBroja {
	public static void main(String[] args) {
		int[] niz = {-1, 9, 7, 3, 5};
		int br = 3;
		
		int koliko = 0;
		for (int i = 0; i < 5; i++) {
			if (niz[i] == br) {
				koliko++;
			}
		}
		
		System.out.println("Broj " + br + " se nalazi u nizu " + koliko + " puta.");
	}
}
