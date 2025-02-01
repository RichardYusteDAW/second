package com.fpmislata.demo.d_persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.fpmislata.demo.c_domain.model.Book;
import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.repository.BookRepository;
import com.fpmislata.demo.d_persistence.jpa.interfaces.BookJpa;
import com.fpmislata.demo.d_persistence.jpa.mapper.BookMapper;
import com.fpmislata.demo.d_persistence.jpa.model.BookEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookJpa bookJpa;

    @Override
    public List<Book> findAll() {
        return BookMapper.INSTANCE.toBookList(bookJpa.findAll());
    }

    @Override
    public ListWithCount<Book> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<BookEntity> bookPage = bookJpa.findAll(pageable);

        List<Book> bookList = BookMapper.INSTANCE.toBookList(bookPage.getContent());
        Integer count = (int) bookPage.getTotalElements();

        return new ListWithCount<>(bookList, count);
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookJpa
                .findById(id)
                .map(b -> BookMapper.INSTANCE.toBook(b));
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return bookJpa
                .findByIsbn(isbn)
                .map(b -> BookMapper.INSTANCE.toBook(b));
    }

    @Override
    public void save(Book book) {
        bookJpa.save(BookMapper.INSTANCE.toBookEntity(book));
    }

    @Override
    public void delete(Integer id) {
        bookJpa.deleteById(id);
    }
}