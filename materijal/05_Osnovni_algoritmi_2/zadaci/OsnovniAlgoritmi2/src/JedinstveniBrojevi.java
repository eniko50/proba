
public class JedinstveniBrojevi {
	public static void main(String[] args) {
		int[] niz = {2,3,4,2,3,5,3,7,2,7,3};
		for (int i = 0; i < niz.length; i++) {
			int brojac = 0;
			for (int j = 0; j < niz.length; j++) {
				if(niz[i]==niz[j]) {
					brojac++;
				}
			}
			if(brojac == 1) {
				System.out.println(niz[i]);
			}
			
		}
		
	}
}
