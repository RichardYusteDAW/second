package fpmislata.bookstore._2presentation.user.mapper;

import org.mapstruct.Mapper;

import fpmislata.bookstore._2presentation.user.model.AuthorCollection;
import fpmislata.bookstore._3domain.user._1model.Author;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorCollection toAuthorCollection(Author author);
}