package vp.nezavisnebiblioteke;

class Drzava {
	private String oznaka;
	private String naziv;

	public Drzava(String oznaka, String naziv) {
		this.oznaka = oznaka;
		this.naziv = naziv;
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
}
