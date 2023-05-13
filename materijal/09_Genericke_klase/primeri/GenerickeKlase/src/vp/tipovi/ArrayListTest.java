package vp.tipovi;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> lista = new ArrayList<String>();
		//dodavanje na kraj liste
		lista.add("Lorem ipsum");
		lista.add("dolor sit amet");
		//dodavanje na poziciju sa indeksom 1
		lista.add(1, "consectetur adipiscing elit");
		String s = lista.get(1);
		lista.remove(1);
		System.out.println(lista);
	}
}
