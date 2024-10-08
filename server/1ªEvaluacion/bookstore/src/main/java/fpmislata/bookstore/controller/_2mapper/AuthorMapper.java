package fpmislata.bookstore.controller._2mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fpmislata.bookstore.controller._1model.AuthorCollection;
import fpmislata.bookstore.controller._1model.AuthorDetail;
import fpmislata.bookstore.domain.model.Author;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorCollection toAuthorCollection(Author author);

    AuthorDetail toAuthorDetail(Author author);
}