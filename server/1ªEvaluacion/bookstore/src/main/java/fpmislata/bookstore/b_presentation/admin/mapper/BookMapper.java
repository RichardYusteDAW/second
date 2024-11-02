package fpmislata.bookstore.b_presentation.admin.mapper;

import java.util.List;

import org.mapstruct.factory.Mappers;

import fpmislata.bookstore.b_presentation.admin.model.BookCollection;
import fpmislata.bookstore.b_presentation.admin.model.BookDetail;
import fpmislata.bookstore.c_domain._2service.model.Book;

public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    List<BookCollection> toBookCollectionList(List<Book> bookList);

    BookDetail toBookDetail(Book book);
}