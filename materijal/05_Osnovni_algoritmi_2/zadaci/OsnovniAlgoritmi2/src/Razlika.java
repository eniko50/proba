
public class Razlika {
	public static void main(String[] args) {
		int[] niz1 = {2,4,1,6,3};
		int[] niz2 = {7,3,4,5,1,8,9};
		for (int i = 0; i < 5; i++) {
			boolean pronadjen = false;
			for (int j = 0; j < 7; j++) {
				if(niz1[i]==niz2[j]) {
					pronadjen = true;
				}
			}
			if(!pronadjen) {
				System.out.println(niz1[i]);
			}
		}
	}
}
