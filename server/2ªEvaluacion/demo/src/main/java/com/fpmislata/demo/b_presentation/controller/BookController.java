package com.fpmislata.demo.b_presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpmislata.demo.b_presentation.mapper.BookMapper;
import com.fpmislata.demo.b_presentation.model.BookComplete;
import com.fpmislata.demo.b_presentation.model.BookSimple;
import com.fpmislata.demo.c_domain.model.Book;
import com.fpmislata.demo.c_domain.usecase.book.interfaces.BookCreateUseCase;
import com.fpmislata.demo.c_domain.usecase.book.interfaces.BookDeleteUseCase;
import com.fpmislata.demo.c_domain.usecase.book.interfaces.BookFindAllUseCase;
import com.fpmislata.demo.c_domain.usecase.book.interfaces.BookFindByIdUseCase;
import com.fpmislata.demo.c_domain.usecase.book.interfaces.BookUpdateUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping(BookController.ENDPOINT)
public class BookController {

    private final BookFindAllUseCase bookFindAllUseCase;
    private final BookFindByIdUseCase bookFindByIdUseCase;
    private final BookCreateUseCase bookCreateUseCase;
    private final BookUpdateUseCase bookUpdateUseCase;
    private final BookDeleteUseCase bookDeleteUseCase;

    @Value("${url}")
    private String url;
    public static final String ENDPOINT = "/books";

    @GetMapping()
    public ResponseEntity<List<BookSimple>> findAll() {
        List<Book> bookList = bookFindAllUseCase.execute();
        List<BookSimple> bookSimpleList = BookMapper.INSTANCE.toBookSimpleList(bookList);

        return ResponseEntity.ok(bookSimpleList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookComplete> findById(@PathVariable Integer id) {
        Book book = bookFindByIdUseCase.execute(id);
        BookComplete bookComplete = BookMapper.INSTANCE.toBookComplete(book);

        return ResponseEntity.ok(bookComplete);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@Valid @RequestBody BookComplete bookComplete) {
        Book book = BookMapper.INSTANCE.toBook(bookComplete);
        bookCreateUseCase.execute(book);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody BookComplete bookComplete) {
        Book book = BookMapper.INSTANCE.toBook(bookComplete);
        book.setId(id);
        bookUpdateUseCase.execute(book);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        bookDeleteUseCase.execute(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}