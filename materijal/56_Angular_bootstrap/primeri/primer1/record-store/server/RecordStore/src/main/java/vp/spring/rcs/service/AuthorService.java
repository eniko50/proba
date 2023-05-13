package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.AuthorRepository;
import vp.spring.rcs.model.Author;

@Component
public class AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	public Author findOne(Long id) {
		return authorRepository.findOne(id);
	}

	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	public Author save(Author author) {
		return authorRepository.save(author);
	}

	public void remove(Long id) {
		authorRepository.delete(id);
	}

	public List<Author> findByName(String name) {
		return authorRepository.findByNameContains(name);
	}


}
