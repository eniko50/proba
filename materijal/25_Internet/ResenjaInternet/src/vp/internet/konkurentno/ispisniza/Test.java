package vp.internet.konkurentno.ispisniza;

public class Test {

	public static void main(String[] args) {
		int[] niz = {2, 7, 6, 5, 4};
		
		for (int i = 0; i < niz.length; i++) {
			Nit nit = new Nit(niz[i]);
			nit.start();
		}

	}

}
