
public class Unija {
	public static void main(String[] args) {
		int[] niz1 = {2,4,1,6,3};
		int[] niz2 = {7,3,4,5,1,8,9};
		for (int i = 0; i < 5; i++) {
			System.out.println(niz1[i]);
		}
		for (int i = 0; i < 7; i++) {
			boolean pronadjen = false;
			for (int j = 0; j < 5; j++) {
				if(niz2[i]==niz1[j]) {
					pronadjen = true;
				}
			}
			if(!pronadjen) {
				System.out.println(niz2[i]);
			}
		}
	}

}
