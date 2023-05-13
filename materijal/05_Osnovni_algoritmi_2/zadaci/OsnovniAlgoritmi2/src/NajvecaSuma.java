
public class NajvecaSuma {
	public static void main(String[] args) {
		int[] niz = {1,4,2,2,3,4,6,7,8,5,4,3,4,5,6,5,4,2,2};
		int maks = niz[0]+niz[1]+niz[2];
		int maksIndeks = 0;
		for (int i = 1; i < niz.length-2; i++) {
			if(niz[i]+niz[i+1]+niz[i+2] > maks) {
				maks = niz[i]+niz[i+1]+niz[i+2];
				maksIndeks = i;
			}
		}
		System.out.println(niz[maksIndeks]+","+niz[maksIndeks+1]+","+niz[maksIndeks+2]);
	}
}
