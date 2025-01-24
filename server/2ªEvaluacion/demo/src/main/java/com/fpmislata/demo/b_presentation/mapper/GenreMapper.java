package com.fpmislata.demo.b_presentation.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fpmislata.demo.b_presentation.model.GenreComplete;
import com.fpmislata.demo.b_presentation.model.GenreSimple;
import com.fpmislata.demo.c_domain.model.Genre;

@Mapper
public interface GenreMapper {

    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    Genre toGenre(GenreComplete genre);

    GenreSimple toGenreSimple(Genre genre);

    GenreComplete toGenreComplete(Genre genre);

    List<GenreSimple> toGenreSimpleList(List<Genre> genreList);
}