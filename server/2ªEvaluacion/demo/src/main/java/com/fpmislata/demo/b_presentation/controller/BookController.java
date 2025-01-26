package com.fpmislata.demo.b_presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
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
    public List<BookSimple> findAll() {
        List<Book> bookList = bookFindAllUseCase.execute();
        return BookMapper.INSTANCE.toBookSimpleList(bookList);
    }

    @GetMapping("/{id}")
    public BookComplete findById(@PathVariable Integer id) {
        Book book = bookFindByIdUseCase.execute(id);
        return BookMapper.INSTANCE.toBookComplete(book);
    }

    @PostMapping()
    public void create(@RequestBody BookComplete bookComplete) {
        Book book = BookMapper.INSTANCE.toBook(bookComplete);
        bookCreateUseCase.execute(book);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody BookComplete bookComplete) {
        Book book = BookMapper.INSTANCE.toBook(bookComplete);
        book.setId(id);
        bookUpdateUseCase.execute(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        bookDeleteUseCase.execute(id);
    }
}