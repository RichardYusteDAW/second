package fpmislata.bookstore.c_domain._1usecase.admin.book.impl;

import fpmislata.bookstore.a_common.annotation.DomainService;
import fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces.BookDeleteAdminUseCase;
import fpmislata.bookstore.c_domain._2service.interfaces.BookService;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class BookDeleteAdminUseCaseImpl implements BookDeleteAdminUseCase {

    private final BookService bookService;

    @Override
    public void execute(Long id) {
        bookService.delete(id);
    }
}