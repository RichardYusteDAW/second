package com.fpmislata.demo.d_persistence.zdao.jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fpmislata.demo.c_domain.model.Publisher;
import com.fpmislata.demo.d_persistence.zdao.jpa.model.PublisherEntity;

@Mapper
public interface PublisherMapper {

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    Publisher toPublisher(PublisherEntity publisherEntity);

    PublisherEntity toPublisherEntity(Publisher publisher);

    List<Publisher> toPublisherList(List<PublisherEntity> publisherEntities);

    List<PublisherEntity> toPublisherEntityList(List<Publisher> publishers);
}