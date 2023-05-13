package vp.ciklusiinizovi;

class Ciklusi {

	public static void main(String[] args) {
		System.out.println("While ciklus");
		int broj = 20;
		while (broj > 1) {
			System.out.println("Broj je: " + broj);
			broj /= 2; 
		}

		System.out.println("Do-while ciklus");	
		broj = 20;
		do {
			System.out.println("Broj je: " + broj);
			broj /= 2; 
		} while (broj > 1);
		
		System.out.println("For ciklus");
		for (int i = 0; i < 5; i++) {			
			System.out.println(i);
		}

		System.out.println("Break i continue naredbe");
		for (int i = 0; i < 10; i++) {
			if (i == 7) {
				break;
			}
			else if (i == 2) {
				continue;
			}
			System.out.println(i);	
		}

	}

}
