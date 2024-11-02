package fpmislata.bookstore.c_domain._1usecase.admin.book.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces.BookGetAllAdminUseCase;
import fpmislata.bookstore.c_domain._2service.interfaces.BookService;
import fpmislata.bookstore.c_domain._2service.model.Book;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookGetAllAdminUseCaseImpl implements BookGetAllAdminUseCase {

    private final BookService bookService;

    @Override
    public List<Book> execute(Integer page, Integer pageSize) {
        return bookService.getAll(page, pageSize);
    }
}