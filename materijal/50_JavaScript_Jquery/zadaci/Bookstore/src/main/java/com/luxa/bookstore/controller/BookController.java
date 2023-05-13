package com.luxa.bookstore.controller;

import com.luxa.bookstore.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private List<Book> books;

    public BookController() {
        books = new ArrayList<>();

        books.add(new Book(1, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "1979", 1000));
        books.add(new Book(2, "The Restaurant at the End of the Universe", "Douglas Adams", "1980", 900));

        books.add(new Book(3, "2001: A Space Odyssey", "Arthur C. Clarke", "1968", 800));
        books.add(new Book(4, "Animal Farm", "George Orwell", "1945", 500));
    }

    @GetMapping
    public ResponseEntity getAllBooks() {
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createBook(@RequestBody Book book) {
        if (books.isEmpty()) {
            book.setId(1);
        } else {
            book.setId(books.get(books.size() - 1).getId() + 1);
        }

        books.add(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable long id) {
        books.removeIf(book -> book.getId() == id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(params = "name")
    public ResponseEntity getByName(@RequestParam String name) {
        final List<Book> filtered = books.stream()
                .filter(book -> book.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(filtered, HttpStatus.OK);
    }

    @GetMapping(params = "author")
    public ResponseEntity getByAuthor(@RequestParam String author) {
        final List<Book> filtered = books.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(filtered, HttpStatus.OK);
    }

    @GetMapping(params = {"from", "to"})
    public ResponseEntity getByPriceRange(@RequestParam int from, @RequestParam int to) {
        final List<Book> filtered = books.stream()
                .filter(book -> book.getCost() >= from && book.getCost() <= to)
                .collect(Collectors.toList());

        return new ResponseEntity<>(filtered, HttpStatus.OK);
    }

}
