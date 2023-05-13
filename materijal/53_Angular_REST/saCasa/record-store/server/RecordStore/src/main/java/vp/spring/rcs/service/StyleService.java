package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.StyleRepository;
import vp.spring.rcs.model.Style;

@Component
public class StyleService {

	@Autowired
	StyleRepository styleRepository;

	public Style findOne(Long id) {
		return styleRepository.findOne(id);
	}

	public List<Style> findAll() {
		return styleRepository.findAll();
	}

	public Style save(Style style) {
		return styleRepository.save(style);
	}

	public void remove(Long id) {
		styleRepository.delete(id);
	}

	public List<Style> findByName(String name) {
		return styleRepository.findByNameContains(name);
	}


}
