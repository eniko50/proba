package vp.sekvencijalnestrukture.stek;

public class Test {
	public static void main(String[] args) {
		Stek<String> imena = new Stek<>();
		imena.push("Marko");
		imena.push("Petar");
		imena.push("Milan");
		imena.push("Jovan"); 
		
		System.out.println("Element na vrhu steka: " + imena.top());
		
		while (!imena.prazan()) {
			System.out.println(imena.pop());
		}
	}
}
