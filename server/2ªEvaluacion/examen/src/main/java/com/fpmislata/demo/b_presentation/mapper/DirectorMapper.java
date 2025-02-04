package com.fpmislata.demo.b_presentation.mapper;

import com.fpmislata.demo.b_presentation.model.DirectorWebModel;
import com.fpmislata.demo.c_domain.model.Director;

public class DirectorMapper {

    public static DirectorWebModel directorToDirectorWebModel(Director director) {
        DirectorWebModel directorWebModel = new DirectorWebModel();
        directorWebModel.setName(director.getName());
        directorWebModel.setBiography(director.getBiography());
        return directorWebModel;
    }
}