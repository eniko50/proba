package vp.spring.rcs.web.dto;

import java.util.List;
import java.util.stream.Collectors;

import vp.spring.rcs.model.Kategorija;

public class KategorijaDTO {
	String naziv;
	List<ArtikalDTO> artikli;
	
	public KategorijaDTO() {
		super();
	}
	
	
	public KategorijaDTO(Kategorija kategorija) {
		this.naziv = kategorija.getNaziv();
//		this.artikli = kategorija.getArtikli().stream().map(a -> new ArtikalDTO(a)).collect(Collectors.toList());
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
