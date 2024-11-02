package fpmislata.bookstore.c_domain._2service.interfaces;

import java.util.List;

import fpmislata.bookstore.c_domain._2service.model.Author;

public interface AuthorService {

        List<Author> findAll();

        List<Author> findAllById(List<Author> authorList);

        Author findById(Long id);

        Author findByBookISBN(Integer bookISBN);

        Long create(String name, String nationality, String biographyEs, String biographyEn, Integer birthYear,
                        Integer deathYear);

        Boolean update(Long id, String name, String nationality, String biographyEs, String biographyEn,
                        Integer birthYear, Integer deathYear);

        Boolean delete(Long id);
}
