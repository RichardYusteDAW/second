package fpmislata.bookstore.c_domain._1usecase.admin.book.impl;

import java.util.List;

import fpmislata.bookstore.a_common.annotation.DomainService;
import fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces.BookGetAllAdminUseCase;
import fpmislata.bookstore.c_domain._2service.interfaces.BookService;
import fpmislata.bookstore.c_domain._2service.model.Book;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class BookGetAllAdminUseCaseImpl implements BookGetAllAdminUseCase {

    private final BookService bookService;

    @Override
    public List<Book> execute(Integer page, Integer size) {
        return bookService.getAll(page, size);
    }
}