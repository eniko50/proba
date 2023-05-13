package vp.osnovnialgoritmi;

public class SrednjaVrednostNiza {
	public static void main(String[] args) {
		int[] niz = {2, 7, 3, 5, 1};
		
		int suma = 0;
		for (int i = 0; i < 5; i++){
			suma += niz[i];
		}
		double srednjaVrednost = suma/5.0;
		System.out.println("Suma je: " + srednjaVrednost);
	}
}
