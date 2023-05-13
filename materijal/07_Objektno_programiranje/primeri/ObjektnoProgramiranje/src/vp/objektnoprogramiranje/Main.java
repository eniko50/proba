package vp.objektnoprogramiranje;

public class Main {
	public static void main(String[] args) {
		Temperatura t = new Temperatura();
		t.vrednostC = 20;
		
		double tempF = t.vrednostUFarenhajtima();
		System.out.println("Vrednost temperature u farenhajtima je: " + tempF);
		
		
		Drzava d = new Drzava();
		d.oznaka = "sr";
		d.naziv = "Srbija";
		
		Grad g = new Grad();
		g.ptt = 21000;
		g.naziv = "Novi Sad";
		g.drzava = d;
		
		g.ispisiGrad();
		
	}
}
