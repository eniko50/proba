package vp.stabla.bst;

public class BinarnoStabloPretrage {
	private Cvor koren;
	
	public void dodaj(int element) {
		if (koren == null) {
			koren = new Cvor(element);
		} else {
			dodaj(koren, element);
		}
	}
	
	private void dodaj(Cvor cvor, int element) {
		if (cvor.vrednost == element) {
			return;
		} else if (cvor.vrednost > element) { // ide se u levo podstablo
			if (cvor.levi == null) {
				cvor.levi = new Cvor(element);
			} else {
				dodaj(cvor.levi, element);
			}
		} else {
			if (cvor.desni == null) {
				cvor.desni = new Cvor(element);
			} else {
				dodaj(cvor.desni, element);
			}
		}
	}
	
	public boolean pronadji(int element) {
		return pronadji(koren, element);
	}
	
	private boolean pronadji(Cvor cvor, int element) {
		if (cvor == null) {
			return false;
		}
		
		if (cvor.vrednost == element) {
			return true;
		} else if (cvor.vrednost > element) {
			return pronadji(cvor.levi, element);
		} else {
			return pronadji(cvor.desni, element);
		}
	}
	
	public void ispisi() {
		if (koren != null) {
			ispisi(koren, 0);
		}
	}
	
	private void ispisi(Cvor cvor, int indent) {
		for (int i = 0 ; i < indent; i++) { // dodamo broj tabova u skladu sa nivoom u stablu
			System.out.print("\t");
		}
		System.out.println(cvor.vrednost);
		
		if (cvor.desni != null) {
			ispisi(cvor.desni, indent + 1);
		}
		if (cvor.levi != null) {
			ispisi(cvor.levi, indent + 1);
		}		
	}
	
	public boolean ukloni(int element) {
		if (koren == null) {
			return false;
		} 
		
		if (koren.vrednost == element) {
			koren = null;
			return true;
		} 
		
		return ukloni(koren, element);
	}
	
	private boolean ukloni(Cvor cvor, int element) {
		if (cvor.vrednost > element) {
			if (cvor.levi == null) {
				return false;
			}
			if (cvor.levi.vrednost == element) {
				cvor.levi = null;
				return true;
			} else {
				return ukloni(cvor.levi, element);
			}		
		} else {
			if (cvor.desni == null) {
				return false;
			}
			if (cvor.desni.vrednost == element) {
				cvor.desni = null;
				return true;
			} else {
				return ukloni(cvor.desni, element);
			}
		}
	}
	
	private class Cvor {
		private int vrednost;
		private Cvor levi;
		private Cvor desni;
		
		Cvor(int vrednost) {
			this.vrednost = vrednost;
		}
	}
}
