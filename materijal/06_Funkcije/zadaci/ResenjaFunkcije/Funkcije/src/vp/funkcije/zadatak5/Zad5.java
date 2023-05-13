package vp.funkcije.zadatak5;

public class Zad5 {
	//funkcija koja pronalazi indeks zadatog elementa u nizu
	public static int find(int[] niz, int vrednost) {
		for (int i = 0; i < niz.length; i++) {
			if (niz[i] == vrednost) {
				//ukoliko je pronadjena prva pojava elementa,
				//vrati se njegov indeks
				//i PREKINE IZVRSAVANJE FUNKCIJE
				return i;
			}
		}
		//ukoliko nije pronadjena ni jedna pojava elementa
		//vrati se -1
		return -1;
	}

	public static void main(String[] args) {
		int[] niz = { 3, 2, 5, 7, 9 };
		int indeks = find(niz, 5);
		System.out.println(indeks);
		indeks = find(niz, 6);
		System.out.println(indeks);
	}
}
