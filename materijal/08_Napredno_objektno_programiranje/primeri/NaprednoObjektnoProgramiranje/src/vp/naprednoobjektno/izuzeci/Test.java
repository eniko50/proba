package vp.naprednoobjektno.izuzeci;

public class Test {
	public void izvrsiSaObradomIzuzetka() {
		UpravljanjeNizom un = new UpravljanjeNizom();
		
		try {
			un.preuzmiElement(4);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void izvrsiSaPropagacijomIzuzetka() throws Exception {
		UpravljanjeNizom un = new UpravljanjeNizom();
		un.preuzmiElement(4);
	}
}
