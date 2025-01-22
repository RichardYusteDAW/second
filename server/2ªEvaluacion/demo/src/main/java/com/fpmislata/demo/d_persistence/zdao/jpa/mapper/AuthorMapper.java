package com.fpmislata.demo.d_persistence.zdao.jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fpmislata.demo.c_domain.model.Author;
import com.fpmislata.demo.d_persistence.zdao.jpa.model.AuthorEntity;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    Author toAuthor(AuthorEntity authorEntity);

    AuthorEntity toAuthorEntity(Author author);

    List<Author> toAuthorList(List<AuthorEntity> authorEntities);

    List<AuthorEntity> toAuthorEntityList(List<Author> authors);
}