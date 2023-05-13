package vp.spring.rcs.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Artikal;
import vp.spring.rcs.model.Korpa;
import vp.spring.rcs.model.user.SecurityUser;
import vp.spring.rcs.service.ArtikalService;
import vp.spring.rcs.service.KorpaService;
import vp.spring.rcs.service.UserDetailsServiceImpl;
import vp.spring.rcs.web.dto.ArtikalDTO;
import vp.spring.rcs.web.dto.KorpaDTO;

@RestController
public class KorpaController {
	
	@Autowired
	KorpaService korpaService;
	@Autowired
	UserDetailsServiceImpl userService;
	@Autowired
	ArtikalService artikalService;
	
	@GetMapping(value = "/api/korpa")
	ResponseEntity<List<Artikal>> getKorpa(@RequestParam(value = "username", required = true) String username){
		Korpa korpa = korpaService.findKorpaByUser(username);
		List<Artikal> artikli = korpa.getArtikli();
//		KorpaDTO korpaDTO= new KorpaDTO(korpa);
		return new ResponseEntity<>(artikli, HttpStatus.OK);
	}
	
	@PostMapping(value = "/api/korpa")
	ResponseEntity<Korpa> putArtickles(@RequestParam(value = "username", required = true) String username, @RequestParam(value = "id",
	required = true ) Long id){
		//kreiraj korpu
		Korpa korpa = korpaService.findKorpaByUser(username);
		Artikal artikal = artikalService.findOne(id);
//		List<Artikal> artikli = ids.stream().map(id -> artikalService.findOne(id)).collect(Collectors.toList());
//		korpa.addArtikli(artikli);
		korpa.addArtikal(artikal);
		korpa = korpaService.save(korpa);
		
		
		
		
//		List<ArtikalDTO> artikliDTO = artikli.stream().map(a -> new ArtikalDTO(a)).collect(Collectors.toList());
	
		
//		korpaDTO.setArtikli(artikliDTO);
		return new ResponseEntity<>(korpa, HttpStatus.OK);
		
		
	}
	

}
