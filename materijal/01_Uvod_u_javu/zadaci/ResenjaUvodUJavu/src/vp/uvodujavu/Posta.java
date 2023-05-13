package vp.uvodujavu;

public class Posta {

	public static void main(String[] args) {
		double tezina = 2.3;
		String primalac = "Petar Petrovic, Strazilovska 13, 21000 Novi Sad";
		String posiljalac = "Marko Markovic, Branislava Nusica 9, 11000 Beograd";
		boolean preporuceno = true;
		
		System.out.println("Posiljalac " + posiljalac + " salje paket primaocu " + 
				primalac + ".");
		System.out.println("\tTezina paketa je: " + tezina);
		System.out.println("\tPoslati preporuceno: " + preporuceno);
	}

}

