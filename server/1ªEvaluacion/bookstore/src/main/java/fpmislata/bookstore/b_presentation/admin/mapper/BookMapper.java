package fpmislata.bookstore.b_presentation.admin.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import fpmislata.bookstore.b_presentation.admin.model.BookCollection;
import fpmislata.bookstore.b_presentation.admin.model.BookDetail;
import fpmislata.bookstore.c_domain._2service.model.Book;

@Mapper(uses = { PublisherMapper.class, AuthorMapper.class })
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    List<BookCollection> toBookCollectionList(List<Book> bookList);

    @Mapping(target = "publisherCollection", source = "publisher")
    @Mapping(target = "authorCollectionList", source = "authors")
    BookDetail toBookDetail(Book book);
}