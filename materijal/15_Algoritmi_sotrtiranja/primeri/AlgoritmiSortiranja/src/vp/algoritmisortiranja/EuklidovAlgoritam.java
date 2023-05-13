package vp.algoritmisortiranja;

public class EuklidovAlgoritam {

	public static void main(String[] args) {
		int a = 25;
		int b = 40;
		while(b != 0) {
			if(b >= a) {
				b -= a;
			} else {
				a -= b;
			}
		}
		System.out.println(a);
	}

}
