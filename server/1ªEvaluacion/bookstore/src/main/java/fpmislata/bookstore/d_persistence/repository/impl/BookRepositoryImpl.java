package fpmislata.bookstore.d_persistence.repository.impl;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import fpmislata.bookstore.c_domain._2service.model.Book;
import fpmislata.bookstore.d_persistence.repository.interfaces.BookRepository;
import fpmislata.bookstore.d_persistence.zdao.interfaces.BookDao;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookDao bookDao;

    @Override
    public List<Book> getAll(int page, int size) {
        return bookDao.getAll(page, size);
    }

    @Override
    public Integer count() {
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return bookDao.findByIsbn(isbn);
    }

    @Override
    public Optional<Book> findById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Optional<Long> save(Book book) {
        return bookDao.save(book);
    }

}
