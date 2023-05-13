package vp.ciklusiinizovi;

public class DeljiviBrojevi {
	public static void main(String[] args) {
		int n = 10;
		int x = 3;
		
		System.out.println("Prvih " + n + " prirodnih brojeva deljivih sa " 
				+ x + " su:");
		for (int i = 1; i <= n; i++) {
			if (i % x == 0) {
				System.out.println(i);
			}
		}
	}
}
