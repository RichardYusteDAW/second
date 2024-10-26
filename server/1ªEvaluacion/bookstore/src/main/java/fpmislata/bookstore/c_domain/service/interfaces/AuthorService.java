package fpmislata.bookstore.c_domain.service.interfaces;

import java.util.List;

import fpmislata.bookstore.c_domain.model.Author;

public interface AuthorService {

        List<Author> findAll();

        Author findById(Integer id);

        Author findByBookISBN(Integer bookISBN);

        Integer create(String name, String nationality, String biographyEs, String biographyEn, Integer birthYear,
                        Integer deathYear);

        Boolean update(Integer id, String name, String nationality, String biographyEs, String biographyEn,
                        Integer birthYear, Integer deathYear);

        Boolean delete(Integer id);
}
