package fpmislata.bookstore.c_domain.usecase.author.interfaces;

import java.util.List;
import fpmislata.bookstore.c_domain.model.Author;

public interface AuthorFindAllUseCase {

    List<Author> execute(Integer page, Integer pageSize);
}