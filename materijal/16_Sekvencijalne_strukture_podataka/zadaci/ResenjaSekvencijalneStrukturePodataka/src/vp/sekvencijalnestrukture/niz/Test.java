package vp.sekvencijalnestrukture.niz;

public class Test {
	public static void main(String[] args) {
		ArrayList<String> imena = new ArrayList<>();
		imena.add("Marko");
		imena.add("Petar");
		imena.add("Milan");
		imena.add(1, "Jovan"); // na poziciju 1 dodajemo ovaj element
		
		for (int i = 0; i < imena.size(); i++) {
			System.out.println(imena.get(i));
		}
		System.out.println("==================");
		
		// element na poziciji 2 je
		System.out.println(imena.get(2));
		
		// da li postoji element Petar
		System.out.println(imena.contains("Petar"));
		
		// brisanje elementa na poziciji 2
		imena.remove(2);
		System.out.println("==================");
		for (int i = 0; i < imena.size(); i++) {
			System.out.println(imena.get(i));
		}
		System.out.println("==================");
		
		// brisanje elementa "Jovan"
		imena.remove("Jovan");
		System.out.println("==================");
		for (int i = 0; i < imena.size(); i++) {
			System.out.println(imena.get(i));
		}
		System.out.println("==================");
	}
}
