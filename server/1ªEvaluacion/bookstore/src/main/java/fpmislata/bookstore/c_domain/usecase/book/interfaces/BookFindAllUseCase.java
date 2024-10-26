package fpmislata.bookstore.c_domain.usecase.book.interfaces;

import java.util.List;
import fpmislata.bookstore.c_domain.model.Book;

public interface BookFindAllUseCase {

    List<Book> execute(Integer page, Integer pageSize);
}