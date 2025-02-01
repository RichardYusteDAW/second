package com.fpmislata.demo.b_presentation.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fpmislata.demo.b_presentation.model.AuthorWebModel;
import com.fpmislata.demo.c_domain.model.Author;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorWebModel toAuthorWebModel(Author author);

    List<AuthorWebModel> toAuthorWebModelList(List<Author> authorList);
}