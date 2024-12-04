package fpmislata.examen.b_presentation.admin.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fpmislata.examen.b_presentation.admin.model.BookCollection;
import fpmislata.examen.c_domain._2service.model.Book;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookCollection toBookCollection(Book book);
}