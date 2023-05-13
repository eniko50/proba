package vp.sekvencijalnestrukture.stek;

import vp.sekvencijalnestrukture.lista.jednostruka.JednostrukoSpregnutaLista;

public class Stek<E> {
	private JednostrukoSpregnutaLista<E> sadrzaj = new JednostrukoSpregnutaLista<>();
	
	public void push(E element) {
		sadrzaj.dodaj(element, 0);
	}
	
	public E top() {
		return sadrzaj.preuzmi(0);
	}
	
	public E pop() {
		E element = sadrzaj.preuzmi(0);
		sadrzaj.obrisi(0);
		return element;
	}
	
	public boolean prazan() {
		return sadrzaj.getVelicina() == 0;
	}
}
