package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.ArtikalRepository;
import vp.spring.rcs.model.Artikal;

@Component
public class ArtikalService {
	@Autowired
	ArtikalRepository artikalRepository;
	
	public Page<Artikal> findAll(Pageable page){
		return artikalRepository.findAll(page);
	}

	public List<Artikal> findAllList() {
		
		return artikalRepository.findAll();
	}

	public Artikal findOne(Long id) {
		return artikalRepository.findOne(id);
	}

}
