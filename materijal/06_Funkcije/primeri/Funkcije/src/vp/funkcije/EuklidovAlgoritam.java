package vp.funkcije;

public class EuklidovAlgoritam {

	static int nzd(int a, int b) {
		while (b != 0) {
			if (b >= a) {
				b -= a;
			} else {
				a -= b;
			}
		}
		return a;
	}
		
	public static void main(String[] args) {
		int rezultat;
		rezultat = nzd(15,25);
		System.out.println(rezultat);
	}
}
