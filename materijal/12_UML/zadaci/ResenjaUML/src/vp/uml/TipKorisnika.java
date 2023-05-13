package vp.uml;

public class TipKorisnika {
	private int id;
	private String naziv;
	
	public TipKorisnika(int id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
}
