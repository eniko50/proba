package vp.spring.rcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Author;
import vp.spring.rcs.service.AuthorService;

@RestController
@RequestMapping(value = "/api/authors")
public class AuthorController {
	
	@Autowired
	AuthorService authorService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Author>> getAll() {
		List<Author> authors = authorService.findAll();
		return new ResponseEntity<>(authors, HttpStatus.OK); 
	}

}
