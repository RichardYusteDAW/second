package com.fpmislata.demo.c_domain.usecase.book.interfaces;

import com.fpmislata.demo.c_domain.model.Book;
import com.fpmislata.demo.c_domain.model.ListWithCount;

public interface BookFindAllWithCountUseCase {
    ListWithCount<Book> execute(Integer page, Integer size);
}