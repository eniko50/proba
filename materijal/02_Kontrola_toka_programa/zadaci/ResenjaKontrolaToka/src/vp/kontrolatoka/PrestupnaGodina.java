package vp.kontrolatoka;

public class PrestupnaGodina {
	public static void main(String[] args) {
		int godina = 1990;
		
		boolean prestupna;
		
		if (godina % 400 == 0) {
			prestupna = true;
		} else if (godina % 100 == 0) {
			prestupna = false; 
		} else if (godina % 4 == 0) {
			prestupna = true;
		} else {
			prestupna = false;
		}
		
		//krace
		/*if (godina % 400 == 0 || (godina % 100 != 0 && godina % 4 == 0)) {
			prestupna = true;
		} else {
			prestupna = false;
		}*/
		
		//jos krace
		//prestupna = godina % 400 == 0 || (godina % 100 != 0 && godina % 4 == 0);
		
		if (prestupna) {
			System.out.println("Godina je prestupna.");
		} else {
			System.out.println("Godina nije prestupna");			
		}
		
		//krace
		//System.out.println("Godina " + (prestupna ? "" : "ni") + "je prestupna");
	}
}
