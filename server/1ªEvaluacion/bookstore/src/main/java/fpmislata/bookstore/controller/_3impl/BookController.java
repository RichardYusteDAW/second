package fpmislata.bookstore.controller._3impl;

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

import fpmislata.bookstore.controller._1model.BookCollection;
import fpmislata.bookstore.controller._1model.BookDetail;
import fpmislata.bookstore.controller._2mapper.BookMapper;
import fpmislata.bookstore.domain.model.AuthorCommand;
import fpmislata.bookstore.domain.model.Book;
import fpmislata.bookstore.domain.model.Category;
import fpmislata.bookstore.domain.model.Genre;
import fpmislata.bookstore.domain.model.Publisher;
import fpmislata.bookstore.domain.service._1interfaceSer.BookService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    // CRUD
    @GetMapping
    public List<BookCollection> findAll() {
        return bookService.findAll()
                .stream()
                .map(book -> BookMapper.INSTANCE.toBookCollection(book))
                .toList();
    }

    @GetMapping("/{ISBN}")
    public BookDetail findByISBN(@PathVariable String ISBN) {
        Book book = bookService.findByISBN(ISBN);
        if (book == null) {
            System.out.println("El libro no existe");
        }
        return BookMapper.INSTANCE.toBookDetail(book);
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
            @RequestParam List<AuthorCommand> authorList,
            @RequestParam List<Genre> genreList) {

        return bookService.create(ISBN, title, synopsis, price, discount, cover, publisher, category, authorList,
                genreList);
    }

    @PutMapping("/{ISBN}")
    public Boolean update(
            @RequestParam String ISBN,
            @RequestParam String title,
            @RequestParam String synopsis,
            @RequestParam BigDecimal price,
            @RequestParam Float discount,
            @RequestParam String cover,
            @RequestParam Publisher publisher,
            @RequestParam Category category,
            @RequestParam List<AuthorCommand> authorList,
            @RequestParam List<Genre> genreList) {

        return bookService.update(ISBN, title, synopsis, price, discount, cover, publisher, category, authorList,
                genreList);
    }

    @DeleteMapping("/{ISBN}")
    public Boolean delete(@PathVariable String ISBN) {
        return bookService.delete(ISBN);
    }
}