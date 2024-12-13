package fpmislata.bookstore.b_presentation.user.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import fpmislata.bookstore.b_presentation.user.model.BookCollection;
import fpmislata.bookstore.c_domain._2service.model.Book;

public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "title", source = "titleEs")
    BookCollection toBookCollection(Book book);
}