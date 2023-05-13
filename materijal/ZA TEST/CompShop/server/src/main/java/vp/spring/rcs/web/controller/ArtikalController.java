package vp.spring.rcs.web.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Artikal;
import vp.spring.rcs.service.ArtikalService;
import vp.spring.rcs.web.dto.ArtikalDTO;


@RestController
public class ArtikalController {
	
	@Autowired
	ArtikalService artikalService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/api/artikli")
	public ResponseEntity<Page<ArtikalDTO>> getArtikli(Pageable page){
		Page<Artikal> artikli = artikalService.findAll(page);
//		List<Artikal> artikli1 = artikalService.findAllList();
		List<ArtikalDTO> artikliDTO = artikli.getContent().stream().map(a -> new ArtikalDTO(a)).collect(Collectors.toList());
		
		Page<ArtikalDTO> retVal = new PageImpl<>(artikliDTO, page, artikliDTO.size());
		return new ResponseEntity<>(retVal, HttpStatus.OK);
			
	}

}
