package com.fpmislata.demo.c_domain.usecase.book.impl;

import java.util.List;

import com.fpmislata.demo.a_common.annotation.UseCase;
import com.fpmislata.demo.a_common.exception.ResourceAlreadyExistsException;
import com.fpmislata.demo.c_domain.model.Author;
import com.fpmislata.demo.c_domain.model.Book;
import com.fpmislata.demo.c_domain.model.Category;
import com.fpmislata.demo.c_domain.model.Genre;
import com.fpmislata.demo.c_domain.model.Publisher;
import com.fpmislata.demo.c_domain.service.interfaces.AuthorService;
import com.fpmislata.demo.c_domain.service.interfaces.BookService;
import com.fpmislata.demo.c_domain.service.interfaces.CategoryService;
import com.fpmislata.demo.c_domain.service.interfaces.GenreService;
import com.fpmislata.demo.c_domain.service.interfaces.PublisherService;
import com.fpmislata.demo.c_domain.usecase.book.interfaces.BookCreateUseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class BookCreateUseCaseImpl implements BookCreateUseCase {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final CategoryService categoryService;
    private final GenreService genreService;
    private final AuthorService authorService;

    @Override
    public void execute(Book book) {
        bookService
                .findByIsbn(book.getIsbn())
                .ifPresent(b -> {
                    throw new ResourceAlreadyExistsException("Book already exists");
                });

        Publisher publisher = publisherService
                .findById(book.getPublisher().getId())
                .orElseThrow(() -> new RuntimeException("Publisher not found"));

        Category category = categoryService
                .findById(book.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        List<Integer> genreIds = book.getGenres().stream().map(g -> g.getId()).toList();
        List<Genre> genres = genreService.findAllByIds(genreIds);

        List<Integer> authorIds = book.getAuthors().stream().map(a -> a.getId()).toList();
        List<Author> authors = authorService.findAllByIds(authorIds);

        book.setPublisher(publisher);
        book.setCategory(category);
        book.setGenres(genres);
        book.setAuthors(authors);

        bookService.create(book);
    }
}