package fpmislata.bookstore.d_persistence.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import fpmislata.bookstore.c_domain._2service.model.Author;
import fpmislata.bookstore.c_domain._2service.model.Book;
import fpmislata.bookstore.d_persistence.repository.interfaces.BookRepository;
import fpmislata.bookstore.d_persistence.zdao.interfaces.AuthorDao;
import fpmislata.bookstore.d_persistence.zdao.interfaces.BookDao;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final AuthorDao authorDao;
    private final BookDao bookDao;

    @Override
    public List<Book> getAll(Integer page, Integer size) {
        return bookDao.getAll(page, size);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {

        Optional<Book> optionalBook = bookDao.findByIsbn(isbn);
        if (optionalBook.isEmpty()) {
            return Optional.empty();
        }

        // Set authors
        Book book = optionalBook.get();
        List<Author> authorList = authorDao.findAllByBookId(book.getId());
        book.setAuthors(authorList);

        return Optional.of(book);
    }

    @Override
    public Optional<Long> save(Book book) {
        List<Author> authorList = book.getAuthors();
        authorList.forEach(author -> {
            authorDao.save(author);
        });
        return bookDao.save(book);
    }

    @Override
    public Integer count() {
        return bookDao.count();
    }
}