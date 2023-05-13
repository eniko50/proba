package vp.funkcije.zadatak8;

public class Zad8 {
	//funkcija koja invertuje matricu
	public static int[][] transponovanje(int[][] matrica){
		int[][] retVal = new int[matrica[0].length][matrica.length];
		for (int i = 0; i < retVal.length; i++) {
			for (int j = 0; j < retVal[0].length; j++) {
				retVal[i][j] = matrica[j][i];
			}
		}
		return retVal;
	}
	//funkcija koja stampa matricu u konzolu
	public static void show(int[][] matrica){
		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < matrica[0].length; j++) {
				System.out.print(matrica[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] matrica = {{1,2},
						   {3,4},
						   {5,6}};
		show(matrica);
		System.out.println();
		int[][] transponovanaMatrica = transponovanje(matrica);
		show(transponovanaMatrica);
	}
}
