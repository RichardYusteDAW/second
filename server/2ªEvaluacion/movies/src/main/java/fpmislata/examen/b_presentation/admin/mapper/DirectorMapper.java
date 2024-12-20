package fpmislata.examen.b_presentation.admin.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fpmislata.examen.b_presentation.admin.model.DirectorSimple;
import fpmislata.examen.c_domain._2service.model.Director;

@Mapper
public interface DirectorMapper {
    DirectorMapper INSTANCE = Mappers.getMapper(DirectorMapper.class);

    List<DirectorSimple> toDirectorSimpleList(List<Director> directors);

    DirectorSimple toDirectorSimple(Director director);
}