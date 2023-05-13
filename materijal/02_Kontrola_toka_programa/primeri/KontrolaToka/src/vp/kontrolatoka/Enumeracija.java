package vp.kontrolatoka;

class Enumeracija {
	
	enum Dan {Ponedeljak, Utorak, Sreda, Cetvrtak, Petak, Subota, Nedelja}
	
	public static void main(String[] args) {		
		Dan d = Dan.Sreda;
		System.out.println(d);		
	}
}
