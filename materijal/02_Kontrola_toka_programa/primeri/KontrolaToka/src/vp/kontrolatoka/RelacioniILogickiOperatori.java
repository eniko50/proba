package vp.kontrolatoka;

class RelacioniILogickiOperatori {

	public static void main(String[] args) {
		//relacioni operatori
		int a = 3;
		int b = 4;
		boolean x = a > b;
		
		System.out.println(a != b);
		
		//logicki operatori
		boolean r = true && false;
		
		boolean b1 = true;
		boolean b2 = false;
		
		r = b1 || b2;
		
		r = b1 && !b2 && b1; 

	}

}
