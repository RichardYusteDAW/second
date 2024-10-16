package fpmislata.bookstore.controller._2mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fpmislata.bookstore.controller._1model.AuthorCollection;
import fpmislata.bookstore.controller._1model.AuthorDetail;
import fpmislata.bookstore.domain.model.AuthorQuery;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorCollection toAuthorCollection(AuthorQuery author);

    AuthorDetail toAuthorDetail(AuthorQuery author);
}