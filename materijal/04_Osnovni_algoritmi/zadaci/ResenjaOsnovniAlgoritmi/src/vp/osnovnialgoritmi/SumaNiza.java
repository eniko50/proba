package vp.osnovnialgoritmi;

public class SumaNiza {
	public static void main(String[] args) {
		int[] niz = {2, 7, 3, 5, 1};
		
		int suma = 0;
		for (int i = 0; i < 5; i++){
			suma += niz[i];
		}
		System.out.println("Suma je: " + suma);
	}
}
