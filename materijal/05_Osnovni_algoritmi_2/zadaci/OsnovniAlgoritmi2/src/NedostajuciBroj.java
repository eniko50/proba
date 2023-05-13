
public class NedostajuciBroj {
	public static void main(String[] args) {
		double[] niz = {1,2,3,5};
		double srednjaVrednost = 3;
		double suma = 0;
		for (int i = 0; i < niz.length; i++) {
			suma += niz[i];
		}		
		double x = srednjaVrednost * (niz.length + 1) - suma;
		System.out.println(x);
	}
}
