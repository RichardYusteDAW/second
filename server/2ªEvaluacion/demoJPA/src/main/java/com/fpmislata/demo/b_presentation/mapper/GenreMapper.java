package com.fpmislata.demo.b_presentation.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fpmislata.demo.b_presentation.model.GenreWebModel;
import com.fpmislata.demo.c_domain.model.Genre;

@Mapper
public interface GenreMapper {

    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    GenreWebModel toGenreWebModel(Genre genre);

    List<GenreWebModel> toGenreWebModelList(List<Genre> genreList);
}