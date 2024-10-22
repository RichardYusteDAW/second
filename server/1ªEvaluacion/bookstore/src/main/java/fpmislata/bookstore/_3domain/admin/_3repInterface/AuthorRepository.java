package fpmislata.bookstore._3domain.admin._3repInterface;

import java.util.List;
import java.util.Optional;

import fpmislata.bookstore._3domain.model.AuthorCommand;
import fpmislata.bookstore._3domain.model.AuthorQuery;

public interface AuthorRepository {

    List<AuthorQuery> findAll();

    Optional<AuthorQuery> findById(Integer id);

    Integer create(AuthorCommand author);

    Boolean update(long id, String name, String nationality, String biography_en, String biography_es,
            Integer birthYear, Integer deathYear);

    Boolean delete(Integer id);
}