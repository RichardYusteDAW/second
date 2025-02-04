package com.fpmislata.demo.b_presentation.mapper;

import com.fpmislata.demo.b_presentation.model.FigureWebModel;
import com.fpmislata.demo.c_domain.model.Figure;

public class FigureMapper {

    public static FigureWebModel figureToFigureWebModel(Figure figure) {
        FigureWebModel figureWebModel = new FigureWebModel();
        figureWebModel.setName(figure.getName());
        figureWebModel.setRole(figure.getRole());
        figureWebModel.setDescription(figure.getDescription());
        return figureWebModel;
    }
}
