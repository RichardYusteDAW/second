package fpmislata.bookstore.b_presentation.admin.mapper;

import java.util.List;
import org.mapstruct.factory.Mappers;

import fpmislata.bookstore.b_presentation.admin.model.AuthorCollection;
import fpmislata.bookstore.b_presentation.admin.model.AuthorDetail;
import fpmislata.bookstore.c_domain._2service.model.Author;

public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    List<AuthorCollection> toAuthorCollectionList(List<Author> authorList);

    AuthorDetail toAuthorDetail(Author author);
}