package vp.kontrolatoka;

public class TipStudija {

	enum Tip {OSNOVNE, MASTER, DOKTORSKE};
	
	public static void main(String[] args) {
		String ime = "Petar";
		String prezime = "Petrovic";
		String brIndeksa = "27382";
		Tip tipStudija = Tip.MASTER;
		
		if (tipStudija == Tip.OSNOVNE) {
			System.out.println("Student je na osnovnim studijama");
		} else if (tipStudija == Tip.MASTER) {
			System.out.println("Student je na master studijama");
		} else {
			System.out.println("Student je na doktorskim studijama");
		}
	}
}
