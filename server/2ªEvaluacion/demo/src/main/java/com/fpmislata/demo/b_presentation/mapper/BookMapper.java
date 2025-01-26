package com.fpmislata.demo.b_presentation.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fpmislata.demo.b_presentation.model.BookComplete;
import com.fpmislata.demo.b_presentation.model.BookSimple;
import com.fpmislata.demo.c_domain.model.Book;

@Mapper(uses = { AuthorMapper.class, CategoryMapper.class, GenreMapper.class, PublisherMapper.class })
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toBook(BookComplete bookComplete);

    BookSimple toBookSimple(Book book);

    BookComplete toBookComplete(Book book);

    List<BookSimple> toBookSimpleList(List<Book> bookList);
}