package vp.funkcije.zadatak7;

public class Zad7 {
	//funkcija koja racuna sumu ispod glavne dijagonale
	public static int sum(int[][] matrica){
		int retVal = 0;
		for (int i = 0; i < matrica.length; i++) {
			for (int j = 0; j < i; j++) {
				retVal += matrica[i][j];
			}
		}
		return retVal;
	}
	
	public static void main(String[] args) {
		int[][] matrica = {{1,2,3},
						   {4,5,6},
						   {7,8,9}};
		int sumaIspodGlavneDijagonale = sum(matrica);
		System.out.println(sumaIspodGlavneDijagonale);
	}
}
