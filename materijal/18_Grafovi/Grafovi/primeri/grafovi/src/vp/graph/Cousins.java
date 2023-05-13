package vp.graph;

public class Cousins {
	/*
	 * Da bi dve osobe bile rodjaci, potrebno je da imaju zajednickog pretka. U
	 * porodicnom stablu, to znaci da postoji predak od kog putanja vodi do obe
	 * osobe. Odnosno, posto je porodicno stablo graf, dve osobe su rodjaci ako
	 * postoji putanja kroz taj graf koja ih povezuje
	 */

	public static void main(String[] args) {
		Node<String> peraPeric = new Node<String>("Pera Peric");
		Node<String> stevaPeric = new Node<String>("Steva Peric");
		Node<String> markoPeric = new Node<String>("Marko Peric");
		Node<String> mitarPeric = new Node<String>("Mitar Peric");

		Node<String> markoMarkovic = new Node<String>("Marko Markovic");
		
		peraPeric.addAdjacentNode(stevaPeric);
		stevaPeric.addAdjacentNode(peraPeric);

		markoPeric.addAdjacentNode(peraPeric);
		peraPeric.addAdjacentNode(markoPeric);

		mitarPeric.addAdjacentNode(stevaPeric);
		stevaPeric.addAdjacentNode(mitarPeric);

		BreathFirstSearch<String> bfs = new BreathFirstSearch<String>();
		System.out
				.println(bfs.findPath(mitarPeric, stevaPeric) == null ? "nisu rodjaci"
						: "jesu rodjaci");
		System.out
		.println(bfs.findPath(mitarPeric, markoMarkovic) == null ? "nisu rodjaci"
				: "jesu rodjaci");

	}
}
