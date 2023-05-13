package vp.sekvencijalnestrukture.red;

public class Test {
	public static void main(String[] args) {
		Red<String> imena = new Red<>();
		imena.add("Marko");
		imena.add("Petar");
		imena.add("Milan");
		imena.add("Jovan"); 
		
		System.out.println("Element na pocetku reda: " + imena.front());
		
		while (!imena.prazan()) {
			System.out.println(imena.remove());
		}
	}
}
