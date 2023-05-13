package com.vp.priprema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vp.priprema.data.BookRepository;
import com.vp.priprema.model.Book;

@Service// @Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
}
