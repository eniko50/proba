package vp.stablo;

import vp.stablo.Stablo.Cvor;

public class Test {

	public static void main(String[] args) {
		Stablo<String> stablo = new Stablo<>();
		
		Stablo<String>.Cvor<String> zivCarstvo = stablo.new Cvor<String>("Životinjsko carstvo", null);
		
		stablo.dodaj(null, zivCarstvo);
		
		Stablo<String>.Cvor<String> beskicmenjaci = stablo.dodaj(zivCarstvo, "Beskičmenjaci");
		Stablo<String>.Cvor<String> kicmenjaci = stablo.dodaj(zivCarstvo, "Kičmenjaci");
		
		Stablo<String>.Cvor<String> mekusci = stablo.dodaj(beskicmenjaci, "Mekušci");
		stablo.dodaj(beskicmenjaci, "Crvi");
		
		Stablo<String>.Cvor<String> sundjerri = stablo.dodaj(mekusci, "Sunđeri");
		stablo.dodaj(sundjerri, "Sunđer Bob");
		
		stablo.dodaj(kicmenjaci, "Sisari");
		Stablo<String>.Cvor<String> ptice = stablo.dodaj(kicmenjaci, "Ptice");
		stablo.dodaj(kicmenjaci, "Gmizavci");
		
		stablo.dodaj(ptice, "Vrabac");
		
		stablo.ispis();
	}

}
