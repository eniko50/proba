package vp.kontrolatoka;

class NaredbaSwitch {

	public static void main(String[] args) {
		int brDana = 3;

		switch (brDana) {
		case 1:
			System.out.println("Ponedeljak");
			break;
		case 2:
			System.out.println("Utorak");
			break;
		case 3:
			System.out.println("Sreda");
			break;
		case 4:
			System.out.println("Cetvrtak");
			break;
		case 5:
			System.out.println("Petak");
			break;
		default:
			System.out.println("Neradni dan");
		}

	}

}
