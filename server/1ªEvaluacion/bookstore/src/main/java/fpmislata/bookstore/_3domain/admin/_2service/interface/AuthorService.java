package fpmislata.bookstore._3domain.admin.service._1interfaceSer;

import java.util.List;

import fpmislata.bookstore._3domain.model.AuthorQuery;

public interface AuthorService {

        List<AuthorQuery> findAll();

        AuthorQuery findById(Integer id);

        Integer create(String name, String nationality, String biography_en, String biography_es, Integer birthYear,
                        Integer deathYear);

        Boolean update(long id, String name, String nationality, String biography_en, String biography_es,
                        Integer birthYear, Integer deathYear);

        Boolean delete(Integer id);
}