package vp.graph;

public class Maze {
	/*
	 *  0123
	 * 0*.**
	 * 1U.**
	 * 2*..I
	 * 3****
	 * 
	 * * je zid u lavirintu
	 * . je prolaz
	 * U je ulaz
	 * I je izlaz
	 * Lavirint posmatramo kao matricu pozicija.
	 * Pozicije u lavirintu predstavljamo kao cvorove grafa.
	 * Ako postoji prolaz izmedju dve pozicije, onda su ta dva cvora povezana.
	 * 
	 * Prolaz kroz lavirint se svodi na pronalazak putanje kroz graf.
	 */
	
	public static void main(String[] args) {
		Node<String> n01 = new Node<String>("(0,1)");
		Node<String> n10 = new Node<String>("(1,0)");//ulaz
		Node<String> n11 = new Node<String>("(1,1)");
		Node<String> n21 = new Node<String>("(2,1)");
		Node<String> n22 = new Node<String>("(2,2)");
		Node<String> n23 = new Node<String>("(2,3)");//izlaz
		
		n01.addAdjacentNode(n11);
		n11.addAdjacentNode(n01);
		
		n10.addAdjacentNode(n11);
		n11.addAdjacentNode(n10);
		
		n11.addAdjacentNode(n21);
		n21.addAdjacentNode(n11);

		n21.addAdjacentNode(n22);
		n22.addAdjacentNode(n21);

		n22.addAdjacentNode(n23);
		n23.addAdjacentNode(n22);
		
		BreathFirstSearch<String> bfs = new BreathFirstSearch<String>();
		System.out.println(bfs.findPath(n10, n23));
		
	}
}
