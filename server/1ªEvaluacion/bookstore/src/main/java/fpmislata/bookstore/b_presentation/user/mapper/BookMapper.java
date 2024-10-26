package fpmislata.bookstore.b_presentation.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import fpmislata.bookstore.b_presentation.user.model.BookCollection;
import fpmislata.bookstore.c_domain.model.Book;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "title", source = "book.titleEs")
    BookCollection toBookCollection(Book book);
}