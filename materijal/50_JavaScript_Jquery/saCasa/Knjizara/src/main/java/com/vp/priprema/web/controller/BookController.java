package com.vp.priprema.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vp.priprema.model.Book;
import com.vp.priprema.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/api/books")
	public ResponseEntity<List<Book>> getAll() {
		List<Book> books = bookService.findAll();
		
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
}
