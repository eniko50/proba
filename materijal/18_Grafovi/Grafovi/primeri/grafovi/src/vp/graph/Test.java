package vp.graph;

public class Test {
	public static void main(String[] args) {
		Node<String> noviSad = new Node<>("Novi Sad");
		Node<String> srbobran = new Node<>("Srbobran");
		Node<String> ruma = new Node<>("Ruma");
		Node<String> sid = new Node<>("Sid");
		Node<String> zrenjanin = new Node<>("Zrenjani");
		Node<String> sombor = new Node<>("Sombor");
		Node<String> subotica = new Node<>("Subotica");
		Node<String> kikinda = new Node<>("Kikinda");
		Node<String> vrsac = new Node<>("Vrsac");
		noviSad.addAdjacentNode(srbobran);
		srbobran.addAdjacentNode(noviSad);
		noviSad.addAdjacentNode(ruma);
		ruma.addAdjacentNode(noviSad);
		noviSad.addAdjacentNode(sid);
		sid.addAdjacentNode(noviSad);
		noviSad.addAdjacentNode(zrenjanin);
		zrenjanin.addAdjacentNode(noviSad);
		ruma.addAdjacentNode(sid);
		sid.addAdjacentNode(ruma);
		srbobran.addAdjacentNode(sombor);
		sombor.addAdjacentNode(srbobran);
		srbobran.addAdjacentNode(subotica);
		subotica.addAdjacentNode(srbobran);
		sombor.addAdjacentNode(subotica);
		subotica.addAdjacentNode(sombor);
		kikinda.addAdjacentNode(subotica);
		subotica.addAdjacentNode(kikinda);
		kikinda.addAdjacentNode(srbobran);
		srbobran.addAdjacentNode(kikinda);
		kikinda.addAdjacentNode(zrenjanin);
		zrenjanin.addAdjacentNode(kikinda);
		vrsac.addAdjacentNode(zrenjanin);
		zrenjanin.addAdjacentNode(vrsac);

		BreathFirstSearch<String> bfs = new BreathFirstSearch<String>();
		System.out.println(bfs.convertToString(noviSad));
	
		System.out.println(bfs.findPath(ruma, subotica));
	}
}
