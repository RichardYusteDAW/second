package fpmislata.bookstore.d_persistence.zdao.interfaces;

import java.util.List;
import java.util.Optional;

import fpmislata.bookstore.c_domain.model.Book;

public interface BookDao {

    List<Book> findAll();

    Optional<Book> findByISBN(String ISBN);

    Integer create(Book book);

    Boolean update(String ISBN, String title, String synopsis, String synopsisEn, String cover, Integer publisherId,
            Integer categoryId, List<Integer> authorList, List<Integer> genreList);

    Boolean delete(String ISBN);
}
