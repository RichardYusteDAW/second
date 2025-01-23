package com.fpmislata.demo.c_domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fpmislata.demo.a_common.exception.ResourceNotFoundException;
import com.fpmislata.demo.c_domain.model.Book;
import com.fpmislata.demo.c_domain.repository.BookRepository;
import com.fpmislata.demo.c_domain.service.interfaces.BookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }

    @Override
    public void create(Book book) {
        Optional<Book> bookOptional = bookRepository.findByIsbn(book.getIsbn());
        if (bookOptional.isPresent()) {
            throw new ResourceNotFoundException("Book already exists");
        }
        bookRepository.save(book);
    }

    @Override
    public void update(Book book) {
        findById(book.getId());
        bookRepository.save(book);
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        bookRepository.delete(id);
    }
}