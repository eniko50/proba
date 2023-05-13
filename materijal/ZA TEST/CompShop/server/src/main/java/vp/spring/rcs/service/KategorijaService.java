package vp.spring.rcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.KategorijaRepository;
import vp.spring.rcs.model.Kategorija;

@Component
public class KategorijaService {
	@Autowired
	KategorijaRepository kategorijaRepository;

	public Page<Kategorija> getAll(Pageable page) {
		
		return kategorijaRepository.findAll(page);
	}

}
