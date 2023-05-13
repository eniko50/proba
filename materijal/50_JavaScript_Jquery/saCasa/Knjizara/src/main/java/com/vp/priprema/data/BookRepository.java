package com.vp.priprema.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vp.priprema.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
}
