package vp.naprednoobjektno.statickeklase;

class Krug {
	double poluprecnik;
	static final double PI = 3.141592653589793;; 
	
	double izracunajObim() {
		return 2 * poluprecnik * PI;
	}
}
