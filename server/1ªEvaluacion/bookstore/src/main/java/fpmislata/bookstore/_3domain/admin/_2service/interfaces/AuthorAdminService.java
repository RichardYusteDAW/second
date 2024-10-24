package fpmislata.bookstore._3domain.admin._2service.interfaces;

import fpmislata.bookstore._3domain.admin._1model.Author;
import java.util.List;

public interface AuthorAdminService {

        List<Author> findAll();

        Author findById(Integer id);

        Author findByBookId(Integer bookId);

        Integer create(String name, String nationality, String biographyEs, String biographyEn, Integer birthYear,
                        Integer deathYear);

        Boolean update(long id, String name, String nationality, String biographyEs, String biographyEn,
                        Integer birthYear, Integer deathYear);

        Boolean delete(Integer id);
}
