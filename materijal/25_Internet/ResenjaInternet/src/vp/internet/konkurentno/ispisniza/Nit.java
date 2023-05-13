package vp.internet.konkurentno.ispisniza;

public class Nit extends Thread {
	private int br;
	
	public Nit(int br) {
		this.br = br;
	}
	
	@Override
	public void run() {
		System.out.println(br);
	}
}
