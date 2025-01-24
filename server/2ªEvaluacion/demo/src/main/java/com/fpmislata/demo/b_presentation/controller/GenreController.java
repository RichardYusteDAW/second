package com.fpmislata.demo.b_presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpmislata.demo.b_presentation.mapper.GenreMapper;
import com.fpmislata.demo.b_presentation.model.GenreComplete;
import com.fpmislata.demo.b_presentation.model.GenreSimple;
import com.fpmislata.demo.c_domain.model.Genre;
import com.fpmislata.demo.c_domain.usecase.genre.interfaces.GenreCreateUseCase;
import com.fpmislata.demo.c_domain.usecase.genre.interfaces.GenreDeleteUseCase;
import com.fpmislata.demo.c_domain.usecase.genre.interfaces.GenreFindAllUseCase;
import com.fpmislata.demo.c_domain.usecase.genre.interfaces.GenreFindByIdUseCase;
import com.fpmislata.demo.c_domain.usecase.genre.interfaces.GenreUpdateUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(GenreController.ENDPOINT)
public class GenreController {

    private final GenreFindAllUseCase genreFindAllUseCase;
    private final GenreFindByIdUseCase genreFindByIdUseCase;
    private final GenreCreateUseCase genreCreateUseCase;
    private final GenreUpdateUseCase genreUpdateUseCase;
    private final GenreDeleteUseCase genreDeleteUseCase;

    @Value("${url}")
    private String url;
    public static final String ENDPOINT = "/genres";

    @GetMapping()
    public List<GenreSimple> findAll() {
        List<Genre> genreList = genreFindAllUseCase.execute();
        return GenreMapper.INSTANCE.toGenreSimpleList(genreList);
    }

    @GetMapping("/{id}")
    public GenreComplete findById(@PathVariable String id) {
        Genre genre = genreFindByIdUseCase.execute(Integer.parseInt(id));
        return GenreMapper.INSTANCE.toGenreComplete(genre);
    }

    @PostMapping()
    public void create(@Valid @RequestBody GenreComplete genreComplete) {
        genreCreateUseCase.execute(GenreMapper.INSTANCE.toGenre(genreComplete));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @Valid @RequestBody GenreComplete genreComplete) {
        Genre genre = GenreMapper.INSTANCE.toGenre(genreComplete);
        genre.setId(Integer.parseInt(id));
        genreUpdateUseCase.execute(genre);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        genreDeleteUseCase.execute(Integer.parseInt(id));
    }
}
