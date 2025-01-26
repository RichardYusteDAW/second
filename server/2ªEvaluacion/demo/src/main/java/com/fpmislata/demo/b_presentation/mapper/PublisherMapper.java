package com.fpmislata.demo.b_presentation.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fpmislata.demo.b_presentation.model.PublisherComplete;
import com.fpmislata.demo.b_presentation.model.PublisherSimple;
import com.fpmislata.demo.c_domain.model.Publisher;

@Mapper
public interface PublisherMapper {

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    Publisher toPublisher(PublisherComplete publisherComplete);

    PublisherSimple toPublisherSimple(Publisher publisher);

    PublisherComplete toPublisherComplete(Publisher publisher);

    List<PublisherSimple> toPublisherSimpleList(List<Publisher> publisherList);
}