package fpmislata.bookstore.b_presentation.admin.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fpmislata.bookstore.b_presentation.admin.model.PublisherCollection;
import fpmislata.bookstore.c_domain._2service.model.Publisher;

@Mapper
public interface PublisherMapper {

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    PublisherCollection toPublisherCollection(Publisher publisher);
}