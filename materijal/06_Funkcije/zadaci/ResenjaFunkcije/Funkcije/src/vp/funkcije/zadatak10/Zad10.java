package vp.funkcije.zadatak10;

public class Zad10 {

	//rekurzivno pronalazenje n-tog fibonacijevog broja
	public static int fibonaci(int n){
		if(n==1||n==2){
			return 1;
		}
		return fibonaci(n-1)+fibonaci(n-2);
	}
	
	public static void main(String[] args) {
		int f = fibonaci(12);
		System.out.println(f);
	}

}
