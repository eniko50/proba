package vp.sekvencijalnestrukture.red;

import vp.sekvencijalnestrukture.lista.jednostruka.JednostrukoSpregnutaLista;

public class Red<E> {
	private JednostrukoSpregnutaLista<E> sadrzaj = new JednostrukoSpregnutaLista<>();
	
	public void add(E element) {
		sadrzaj.dodaj(element);
	}
	
	public E front() {
		return sadrzaj.preuzmi(0);
	}
	
	public E remove() {
		E element = sadrzaj.preuzmi(0);
		sadrzaj.obrisi(0);
		return element;
	}
	
	public boolean prazan() {
		return sadrzaj.getVelicina() == 0;
	}
}
