package vp.naprednoobjektno.enkapsulacija;

public class Krug {
	private double poluprecnik;
	public static final double PI = 3.141592653589793;;
	
	Krug() {
		
	}
	
	Krug(double poluprecnik) {
		this.poluprecnik = poluprecnik;
	}
	
	public double getPoluprecnik() {
		return poluprecnik;
	}

	public void setPoluprecnik(double poluprecnik) {
		this.poluprecnik = poluprecnik;
	}

	double izracunajObim() {
		return 2 * poluprecnik * PI;
	}
}
