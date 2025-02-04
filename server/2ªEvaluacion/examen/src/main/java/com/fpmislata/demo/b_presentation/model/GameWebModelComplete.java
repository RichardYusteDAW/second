package com.fpmislata.demo.b_presentation.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameWebModelComplete {

    String gameCode;
    String title;
    Integer releaseYear;
    String description;
    DirectorWebModel director;
    List<FigureWebModel> characters;
}