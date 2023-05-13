package vp.kontrolatoka;

public class Operacija {

	public static void main(String[] args) {

		int x = 5;
		int y = 9;
		String operacija = "swap";

		switch (operacija) {
		case "min":
			if (x < y) {
				System.out.println(x);
			} else {
				System.out.println(y);
			}
			
			// kraci nacin
			// System.out.println(x < y ? x : y);
			break;
		case "max":
			if (x > y) {
				System.out.println(x);
			} else {
				System.out.println(y);
			}	
			break;
		case "swap":
			int temp = x;
			x = y;
			y = temp;
			
			System.out.println(x);
			System.out.println(y);
			break;
		case "equals":
			if (x > y) {
				System.out.println(1);
			} else if (x < y) {
				System.out.println(-1);
			} else {
				System.out.println(0);
			}
			break;
		}
	}
}
