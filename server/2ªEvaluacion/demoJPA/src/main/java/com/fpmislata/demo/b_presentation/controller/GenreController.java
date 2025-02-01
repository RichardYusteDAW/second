package com.fpmislata.demo.b_presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpmislata.demo.b_presentation.mapper.GenreMapper;
import com.fpmislata.demo.b_presentation.model.GenreWebModel;
import com.fpmislata.demo.b_presentation.model.Paginator;
import com.fpmislata.demo.c_domain.model.Genre;
import com.fpmislata.demo.c_domain.model.ListWithCount;
import com.fpmislata.demo.c_domain.usecase.genre.interfaces.GenreCreateUseCase;
import com.fpmislata.demo.c_domain.usecase.genre.interfaces.GenreDeleteUseCase;
import com.fpmislata.demo.c_domain.usecase.genre.interfaces.GenreFindAllUseCase;
import com.fpmislata.demo.c_domain.usecase.genre.interfaces.GenreFindAllWithCountUseCase;
import com.fpmislata.demo.c_domain.usecase.genre.interfaces.GenreFindByIdUseCase;
import com.fpmislata.demo.c_domain.usecase.genre.interfaces.GenreUpdateUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(GenreController.ENDPOINT)
public class GenreController {

    private final GenreFindAllUseCase genreFindAllUseCase;
    private final GenreFindAllWithCountUseCase genreFindAllWithCountUseCase;
    private final GenreFindByIdUseCase genreFindByIdUseCase;
    private final GenreCreateUseCase genreCreateUseCase;
    private final GenreUpdateUseCase genreUpdateUseCase;
    private final GenreDeleteUseCase genreDeleteUseCase;

    @Value("${URL}")
    private String URL;
    public static final String ENDPOINT = "/genres";

    @GetMapping()
    public ResponseEntity<List<GenreWebModel>> findAll() {
        List<Genre> genreList = genreFindAllUseCase.execute();
        List<GenreWebModel> genreWebGenreWebModelList = GenreMapper.INSTANCE.toGenreWebModelList(genreList);

        return ResponseEntity.ok(genreWebGenreWebModelList);
    }

    @GetMapping("/paginator")
    public ResponseEntity<Paginator<GenreWebModel>> findAllAllWithCount(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {

        ListWithCount<Genre> genreListWithCount = genreFindAllWithCountUseCase.execute(page, pageSize);

        List<GenreWebModel> genreWebGenreWebModelList = GenreMapper.INSTANCE
                .toGenreWebModelList(genreListWithCount.getList());
        Integer total = genreListWithCount.getCount();
        String baseURL = URL + ENDPOINT;

        Paginator<GenreWebModel> genreWebGenreWebModelPaginator = new Paginator<>(genreWebGenreWebModelList, total,
                page, pageSize, baseURL);

        return ResponseEntity.ok(genreWebGenreWebModelPaginator);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> findById(@PathVariable Integer id) {
        Genre genre = genreFindByIdUseCase.execute(id);

        return ResponseEntity.ok(genre);
    }

    @PostMapping()
    public ResponseEntity<Void> create(@Valid @RequestBody Genre genre) {
        genreCreateUseCase.execute(genre);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody Genre genre) {
        genre.setId(id);
        genreUpdateUseCase.execute(genre);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        genreDeleteUseCase.execute(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}