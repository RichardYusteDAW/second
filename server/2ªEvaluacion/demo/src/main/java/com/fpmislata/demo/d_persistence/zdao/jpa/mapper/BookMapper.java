package com.fpmislata.demo.d_persistence.zdao.jpa.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.fpmislata.demo.c_domain.model.Book;
import com.fpmislata.demo.d_persistence.zdao.jpa.model.BookEntity;

@Mapper(uses = { AuthorMapper.class, GenreMapper.class, PublisherMapper.class, CategoryMapper.class })
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Named("toBook")
    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "publisher", ignore = true)
    @Mapping(target = "category", ignore = true)
    Book toBook(BookEntity bookEntity);

    Book toBookWithDetails(BookEntity bookEntity);

    BookEntity toBookEntity(Book book);

    @IterableMapping(qualifiedByName = "toBook")
    List<Book> toBookList(List<BookEntity> bookEntities);

    List<BookEntity> toBookEntityList(List<Book> books);
}