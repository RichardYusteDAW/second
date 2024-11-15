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
    public List<Book> getAll(int page, int size) {
        return bookDao.getAll(page, size);
    }

    @Override
    public Integer count() {
        return bookDao.count();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {

        Optional<Book> optionalBook = bookDao.findByIsbn(isbn);
        if (!optionalBook.isPresent())
            return Optional.empty();

        // Set authors
        Book book = optionalBook.get();
        List<Author> authors = authorDao.findAllByBookId(book.getId());
        book.setAuthors(authors);

        return Optional.of(book);
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
