package fpmislata.bookstore.controller._2mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fpmislata.bookstore.controller._1model.BookCollection;
import fpmislata.bookstore.controller._1model.BookDetail;
import fpmislata.bookstore.domain.model.Book;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookCollection toBookCollection(Book book);

    BookDetail toBookDetail(Book book);
}