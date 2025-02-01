package com.fpmislata.demo.b_presentation.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fpmislata.demo.b_presentation.model.BookWebModel;
import com.fpmislata.demo.c_domain.model.Book;

@Mapper(uses = { AuthorMapper.class, CategoryMapper.class, GenreMapper.class, PublisherMapper.class })
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookWebModel toBookWebModel(Book book);

    List<BookWebModel> toBookWebModelList(List<Book> bookList);
}