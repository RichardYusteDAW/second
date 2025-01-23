package com.fpmislata.demo.c_domain.usecase.book.interfaces;

import com.fpmislata.demo.c_domain.model.Book;

public interface BookFindByIdUseCase {
    Book execute(Integer id);
}
