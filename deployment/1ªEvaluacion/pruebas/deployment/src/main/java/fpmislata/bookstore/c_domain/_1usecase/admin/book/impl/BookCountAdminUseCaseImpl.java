package fpmislata.bookstore.c_domain._1usecase.admin.book.impl;

import fpmislata.bookstore.a_common.annotation.DomainService;
import fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces.BookCountAdminUseCase;
import fpmislata.bookstore.c_domain._2service.interfaces.BookService;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class BookCountAdminUseCaseImpl implements BookCountAdminUseCase {

    private final BookService bookService;

    public Integer execute() {
        return bookService.count();
    }
}
