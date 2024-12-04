package fpmislata.examen.b_presentation.admin.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fpmislata.examen.b_presentation.admin.model.UserCollection;
import fpmislata.examen.c_domain._2service.model.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserCollection toUserCollection(User user);
}