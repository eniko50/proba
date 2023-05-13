package vp.ciklusiinizovi;

public class PronalazenjeBroja {
	public static void main(String[] args) {
		int[] niz = {-1, 9, 7, 3, 5};
		int br = 4;
		
		boolean nasao = false;
		for (int i = 0; i < 5; i++) {
			if (niz[i] == br) {
				nasao = true;
				break; //nema potrebe za daljom pretragom
			}
		}
		
		if (nasao) {
			System.out.println("Broj " + br + " se nalazi u nizu.");
		} else {
			System.out.println("Broj " + br + " se ne nalazi u nizu.");
		}
	}
}
