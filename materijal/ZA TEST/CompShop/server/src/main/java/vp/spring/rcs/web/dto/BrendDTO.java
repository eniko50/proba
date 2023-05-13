package vp.spring.rcs.web.dto;

import java.util.List;
import java.util.stream.Collectors;

import vp.spring.rcs.model.Artikal;
import vp.spring.rcs.model.Brend;

public class BrendDTO {
	
	String naziv;
	List<ArtikalDTO> artikli;
	
		public BrendDTO(Brend brend) {
		this.naziv = brend.getNaziv();
//		this.artikli = brend.getArtikli().stream().map(a -> new ArtikalDTO(a)).collect(Collectors.toList());
	}




	public BrendDTO() {
		super();
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public List<ArtikalDTO> getArtikli() {
		return artikli;
	}


	public void setArtikli(List<ArtikalDTO> artikli) {
		this.artikli = artikli;
	}
	
	
	
	

}
