package com.fpmislata.demo.b_presentation.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fpmislata.demo.b_presentation.model.PublisherWebModel;
import com.fpmislata.demo.c_domain.model.Publisher;

@Mapper
public interface PublisherMapper {

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    PublisherWebModel toPublisherWebModel(Publisher publisher);

    List<PublisherWebModel> toPublisherWebModelList(List<Publisher> publisherList);
}