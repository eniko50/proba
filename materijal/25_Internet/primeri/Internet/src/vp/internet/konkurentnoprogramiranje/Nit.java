package vp.internet.konkurentnoprogramiranje;

public class Nit extends Thread {
	int oznaka;
	
	public Nit(int oznaka) {
		this.oznaka = oznaka;
	}
	
	@Override
	public void run() {
		System.out.println("Ispis iz niti: " + oznaka);
	}
}
