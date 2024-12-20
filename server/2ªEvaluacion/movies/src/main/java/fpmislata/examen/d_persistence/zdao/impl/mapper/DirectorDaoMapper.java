package fpmislata.examen.d_persistence.zdao.impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fpmislata.examen.c_domain._2service.model.Director;
import fpmislata.examen.d_persistence.zdao.impl.model.DirectorDaoModel;

@Mapper
public interface DirectorDaoMapper {

    DirectorDaoMapper INSTANCE = Mappers.getMapper(DirectorDaoMapper.class);

    Director toDirector(DirectorDaoModel directorDaoModel);

    DirectorDaoModel toDirectorDaoModel(Director director);
}