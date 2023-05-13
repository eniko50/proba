
public class XOR {
	public static void main(String[] args) {
		int[] x = {1,0,0,1,0,1};
		int[] y = {0,1,1,1,0,0};
		int[] rezultat = {0,0,0,0,0,0};
		for (int i = 0; i < 6; i++) {
			if((x[i]==0&&y[i]==1)||(x[i]==1&&y[i]==0)) {
				rezultat[i]=1;
			}
		}
		for (int i = 0; i < 6; i++) {
			System.out.print(rezultat[i]);
		}
	}
}
