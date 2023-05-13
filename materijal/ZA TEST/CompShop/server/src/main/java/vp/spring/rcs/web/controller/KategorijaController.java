package vp.spring.rcs.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Kategorija;
import vp.spring.rcs.service.ArtikalService;
import vp.spring.rcs.service.KategorijaService;
import vp.spring.rcs.web.dto.ArtikalDTO;
import vp.spring.rcs.web.dto.KategorijaDTO;

@RestController
public class KategorijaController {
	
	@Autowired
	KategorijaService kategorijaService;
	@Autowired
	ArtikalService artikalService;
	
	
	@GetMapping(value="api/kategorije")
	public ResponseEntity<Page<KategorijaDTO>> getAllKAtegorije(Pageable page){
		Page<Kategorija> kategorije = kategorijaService.getAll(page);
		List<KategorijaDTO> kategorijeDTO = kategorije.getContent().stream().map(k -> new KategorijaDTO(k)).collect(Collectors.toList());
		List<ArtikalDTO> artikli = artikalService.findAllList().stream().map(a -> new ArtikalDTO(a)).collect(Collectors.toList());
		for(KategorijaDTO n : kategorijeDTO) {
			n.setArtikli(artikli);
		}
		
		
		Page<KategorijaDTO> retVal = new PageImpl<>(kategorijeDTO, page, kategorije.getTotalElements());
		return new ResponseEntity<>(retVal, HttpStatus.OK);
		
		
	}
	 

}
