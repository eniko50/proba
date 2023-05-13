
public class Permutacije {
	public static void main(String[] args) {
		int[] niz1 = { 1, 1, 2, 3, 2, 4 };
		int[] niz2 = { 2, 2, 1, 1, 3, 4 };
		boolean permutacija = true;
		if (niz1.length != niz2.length) {
			permutacija = false;
		} else {
			for (int i = 0; i < niz1.length; i++) {
				int brojPojava1 = 0;
				for (int j = 0; j < niz1.length; j++) {
					if (niz1[i] == niz1[j]) {
						brojPojava1++;
					}
				}
				int brojPojava2 = 0;
				for (int j = 0; j < niz1.length; j++) {
					if (niz1[i] == niz2[j]) {
						brojPojava2++;
					}
				}
				if (brojPojava1 != brojPojava2) {
					permutacija = false;
					break;
				}
			}
		}
		if (permutacija) {
			System.out.println("permutacije");
		} else {
			System.out.println("nisu permutacije");
		}
	}
}
