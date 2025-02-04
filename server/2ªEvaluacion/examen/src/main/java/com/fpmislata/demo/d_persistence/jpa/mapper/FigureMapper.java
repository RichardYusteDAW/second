package com.fpmislata.demo.d_persistence.jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fpmislata.demo.c_domain.model.Figure;
import com.fpmislata.demo.d_persistence.jpa.model.FigureEntity;

@Mapper
public interface FigureMapper {

    FigureMapper INSTANCE = Mappers.getMapper(FigureMapper.class);

    Figure toFigure(FigureEntity figureEntity);

    FigureEntity toFigureEntity(Figure figure);

    List<Figure> toFigureList(List<FigureEntity> figureEntityList);

    List<FigureEntity> toFigureEntityList(List<Figure> figureList);
}
