package fpmislata.bookstore._2presentation.admin.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import fpmislata.bookstore._2presentation.admin.model.BookCollection;
import fpmislata.bookstore._3domain.admin._1model.Book;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "title", source = "book.title")
    BookCollection toBookCollection(Book book);
}