package vp.tipovi;

public class KonverzijaTipova {
	public static void main(String[] args) {
		Number x;
		Float f = new Float(5);
		x = f;
		f = (Float) x;
	}
}
