package vp.funkcije;

public class Faktorijel {
	
	static int faktorijel(int x){
		if(x==1){
			return 1;
		}
		else{
			return x*faktorijel(x-1);
		}
	}
	
	static int faktorijelItarativni(int x){
		int retVal = 1;
		while(x>1){
			retVal *= x;
			x -= 1;
		}
		return retVal;
	}
	
	public static void main(String[] args) {
		int rezultat;
		rezultat = faktorijelItarativni(3);
		System.out.println(rezultat);
	}
}
