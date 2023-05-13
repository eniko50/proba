package vp.spring.rcs.web.dto;

import java.util.List;
import java.util.stream.Collectors;

import vp.spring.rcs.model.Korpa;

public class KorpaDTO {
	
	List<ArtikalDTO> artikli;
	
	UserDTO userDTO;

	public KorpaDTO(Korpa korpa) {
		super();
//		this.artikli = korpa.getArtikli().stream().map(a -> new ArtikalDTO(a)).collect(Collectors.toList());
		this.userDTO = new UserDTO(korpa.getUser());
	}

	public KorpaDTO() {
		super();
	}

	public List<ArtikalDTO> getArtikli() {
		return artikli;
	}

	public void setArtikli(List<ArtikalDTO> artikli) {
		this.artikli = artikli;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public void addArtikal(ArtikalDTO artikalDTO) {
		this.artikli.add(artikalDTO);
		
	}
	
	
}
