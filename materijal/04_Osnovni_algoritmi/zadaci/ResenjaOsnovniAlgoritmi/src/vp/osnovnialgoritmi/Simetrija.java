package vp.osnovnialgoritmi;

public class Simetrija {
	public static void main(String[] args) {
		int[] niz = {2, 7, 9, 9, 7, 2};
		int n = 6; // duzina niza
		
		boolean simetrican = true;
		for (int i = 0; i < n/2; i++) {
			if (niz[i] != niz[n - i - 1]) {
				simetrican = false;
				break;
			}
		}
		
		System.out.println("Niz " + (simetrican ? "je" : "nije") + " simetrican");
		
		
	}
}
