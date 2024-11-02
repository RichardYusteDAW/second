package fpmislata.bookstore.c_domain._1usecase.admin.book.interfaces;

import java.util.List;

import fpmislata.bookstore.c_domain._2service.model.Book;

public interface BookGetAllAdminUseCase {

    List<Book> execute(Integer page, Integer pageSize);
}