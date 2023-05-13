package vp.naprednoobjektno.statickeklase;

class MatematickeOperacije {
	static int brojPoziva = 0;
	
	static int kvadriraj(int x) {
		brojPoziva++;
		return x * x;
	}

}
