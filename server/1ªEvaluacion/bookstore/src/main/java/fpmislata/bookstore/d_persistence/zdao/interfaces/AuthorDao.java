package fpmislata.bookstore.d_persistence.zdao.interfaces;

import java.util.List;

import fpmislata.bookstore.c_domain._2service.model.Author;

public interface AuthorDao extends GenericDao<Author> {

    List<Author> findAllByBookId(Long bookId);
}
