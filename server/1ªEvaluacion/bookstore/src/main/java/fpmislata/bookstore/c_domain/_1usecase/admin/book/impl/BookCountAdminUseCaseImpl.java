package fpmislata.bookstore.c_domain._1usecase.admin.book.impl;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces.BookCountAdminUseCase;
import fpmislata.bookstore.c_domain._2service.interfaces.BookService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookCountAdminUseCaseImpl implements BookCountAdminUseCase {

    private final BookService bookService;

    public Integer execute() {
        return bookService.count();
    }
}
