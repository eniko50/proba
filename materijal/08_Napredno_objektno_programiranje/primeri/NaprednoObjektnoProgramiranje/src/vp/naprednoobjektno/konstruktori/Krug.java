package vp.naprednoobjektno.konstruktori;

class Krug {
	double poluprecnik;
	static final double PI = 3.141592653589793;;
	
	Krug() {
		
	}
	
	Krug(double poluprecnik) {
		this.poluprecnik = poluprecnik;
	}
	
	double izracunajObim() {
		return 2 * poluprecnik * PI;
	}
}
