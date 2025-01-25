package com.fpmislata.demo.b_presentation.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fpmislata.demo.b_presentation.model.AuthorComplete;
import com.fpmislata.demo.b_presentation.model.AuthorSimple;
import com.fpmislata.demo.c_domain.model.Author;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    Author toAuthor(AuthorComplete authorComplete);

    AuthorSimple toAuthorSimple(Author author);

    AuthorComplete toAuthorComplete(Author author);

    List<AuthorSimple> toAuthorSimpleList(List<Author> authorList);
}