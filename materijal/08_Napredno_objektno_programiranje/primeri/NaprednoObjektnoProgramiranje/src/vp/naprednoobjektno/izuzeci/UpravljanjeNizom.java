package vp.naprednoobjektno.izuzeci;

public class UpravljanjeNizom {
	private int[] niz = {3, 7, 8};
	
	public int preuzmiElement(int indeksElementa) throws Exception {
		if (indeksElementa < 0) {
			throw new Exception("Negativan indeks");
		}
		return niz[indeksElementa];  
	}

}
