package fpmislata.bookstore.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fpmislata.bookstore.domain.model.Author;
import fpmislata.bookstore.domain.model.Book;
import fpmislata.bookstore.domain.model.Category;
import fpmislata.bookstore.domain.model.Genre;
import fpmislata.bookstore.domain.model.Publisher;
import fpmislata.bookstore.domain.service.interfaceSer.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    BookService bookService;

    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // CRUD
    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable String ISBN) {
        return bookService.findByISBN(ISBN);
    }

    @PostMapping()
    public Integer create(
            @RequestParam String ISBN,
            @RequestParam String title,
            @RequestParam String synopsis,
            @RequestParam BigDecimal price,
            @RequestParam Float discount,
            @RequestParam String cover,
            @RequestParam Publisher publisher,
            @RequestParam Category category,
            @RequestParam List<Author> authorList,
            @RequestParam List<Genre> genreList) {

        return bookService.create(ISBN, title, synopsis, price, discount, cover, publisher, category, authorList,
                genreList);
    }

    @PutMapping("/{id}")
    public Integer update(
            @RequestParam String ISBN,
            @RequestParam String title,
            @RequestParam String synopsis,
            @RequestParam BigDecimal price,
            @RequestParam Float discount,
            @RequestParam String cover,
            @RequestParam Publisher publisher,
            @RequestParam Category category,
            @RequestParam List<Author> authorList,
            @RequestParam List<Genre> genreList) {

        return bookService.update(ISBN, title, synopsis, price, discount, cover, publisher, category, authorList,
                genreList);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable String ISBN) {
        return bookService.delete(ISBN);
    }

}