package vp.tipovi;

public class TestKutija {

	public static void main(String[] args) {
		int x = 1;
		String s = "Zdravo!";
		Kutija<Integer> kutijaInt = new Kutija<>(x);
		//Kutija<int> kutijaPrimitivniTip = new Kutija<>(x);
		Kutija<String> kutijaStr = new Kutija<>(s);
		System.out.println(kutijaInt.getSadrzaj());
		System.out.println(kutijaStr.getSadrzaj());
	}
}
