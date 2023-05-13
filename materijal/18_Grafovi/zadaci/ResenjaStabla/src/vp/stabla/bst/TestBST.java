package vp.stabla.bst;

public class TestBST {
	public static void main(String[] args) {
		BinarnoStabloPretrage stablo = new BinarnoStabloPretrage();
		
		stablo.dodaj(5);
		stablo.dodaj(3);
		stablo.dodaj(2);
		stablo.dodaj(19);
		stablo.dodaj(4);
		stablo.dodaj(26);
		stablo.dodaj(14);
		
		System.out.println(stablo.pronadji(15));
		System.out.println(stablo.pronadji(5));
		
		stablo.ispisi();
		
		stablo.ukloni(3);
		System.out.println("=========== Stablo nakon uklanjanja elementa ===========");
		stablo.ispisi();
	}
}
