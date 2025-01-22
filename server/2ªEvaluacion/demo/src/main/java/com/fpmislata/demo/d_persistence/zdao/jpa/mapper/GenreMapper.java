package com.fpmislata.demo.d_persistence.zdao.jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fpmislata.demo.c_domain.model.Genre;
import com.fpmislata.demo.d_persistence.zdao.jpa.model.GenreEntity;

@Mapper
public interface GenreMapper {
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    Genre toGenre(GenreEntity genreEntity);

    GenreEntity toGenreEntity(Genre genre);

    List<Genre> toGenreList(List<GenreEntity> genreEntities);

    List<GenreEntity> toGenreEntityList(List<Genre> genres);
}