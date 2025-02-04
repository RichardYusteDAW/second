package com.fpmislata.demo.d_persistence.jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fpmislata.demo.c_domain.model.Director;
import com.fpmislata.demo.d_persistence.jpa.model.DirectorEntity;

@Mapper
public interface DirectorMapper {

    DirectorMapper INSTANCE = Mappers.getMapper(DirectorMapper.class);

    Director toDirector(DirectorEntity directorEntitiy);

    DirectorEntity toDirectorEntitiy(Director director);

    List<Director> toDirectorList(List<DirectorEntity> directorEntitiyList);

    List<DirectorEntity> toDirectorEntitiyList(List<Director> directorList);
}
