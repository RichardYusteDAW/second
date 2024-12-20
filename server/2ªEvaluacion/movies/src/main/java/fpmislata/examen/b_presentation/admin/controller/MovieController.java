package fpmislata.examen.b_presentation.admin.controller;

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

import fpmislata.examen.b_presentation.admin.mapper.DirectorMapper;
import fpmislata.examen.b_presentation.admin.mapper.MovieMapper;
import fpmislata.examen.b_presentation.admin.model.DirectorSimple;
import fpmislata.examen.b_presentation.admin.model.MovieComplete;
import fpmislata.examen.b_presentation.admin.model.MovieSimple;
import fpmislata.examen.b_presentation.common.Paginator;
import fpmislata.examen.c_domain._1usecase.admin.movie.interfaces.MovieAddActorsUseCase;
import fpmislata.examen.c_domain._1usecase.admin.movie.interfaces.MovieCreateUseCase;
import fpmislata.examen.c_domain._1usecase.admin.movie.interfaces.MovieDeleteUseCase;
import fpmislata.examen.c_domain._1usecase.admin.movie.interfaces.MovieUpdateUseCase;
import fpmislata.examen.c_domain._1usecase.common.director.interfaces.DirectorFindByMovieIdUseCase;
import fpmislata.examen.c_domain._1usecase.common.movie.interfaces.MovieFindAllUseCase;
import fpmislata.examen.c_domain._1usecase.common.movie.interfaces.MovieFindByIdUseCase;
import fpmislata.examen.c_domain._2service.model.Actor;
import fpmislata.examen.c_domain._2service.model.Director;
import fpmislata.examen.c_domain._2service.model.ListWithCount;
import fpmislata.examen.c_domain._2service.model.Movie;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(MovieController.ENDPOINT)
public class MovieController {

    private final MovieFindAllUseCase movieFindAllUseCase;
    private final MovieFindByIdUseCase movieFindByIdUseCase;
    private final MovieCreateUseCase movieCreateUseCase;
    private final MovieUpdateUseCase movieUpdateUseCase;
    private final MovieDeleteUseCase movieDeleteUseCase;
    private final MovieAddActorsUseCase movieAddActorsUseCase;

    private final DirectorFindByMovieIdUseCase directorFindAllByMovieIdUseCase;

    @Value("${url}")
    private String URL;
    public static final String ENDPOINT = "/api/admin/movies";

    @GetMapping()
    public ResponseEntity<Paginator<MovieSimple>> findAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {

        ListWithCount<Movie> movieListWithCount = movieFindAllUseCase.execute(page - 1, size);
        List<MovieSimple> movieSimpleList = MovieMapper.INSTANCE.toMovieSimpleList(movieListWithCount.list());
        Paginator<MovieSimple> paginator = new Paginator<>(movieSimpleList, movieListWithCount.count(), page, size,
                URL + ENDPOINT);

        return ResponseEntity.ok(paginator);
    }

    @GetMapping("/{id}/directors")
    public ResponseEntity<DirectorSimple> findAllByDirectorId(
            @PathVariable Integer id,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        Director director = directorFindAllByMovieIdUseCase.execute(id);
        DirectorSimple directorSimple = DirectorMapper.INSTANCE.toDirectorSimple(director);

        return ResponseEntity.ok(directorSimple);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieComplete> findById(@PathVariable Integer id) {
        Movie movie = movieFindByIdUseCase.execute(id);
        MovieComplete MovieComplete = MovieMapper.INSTANCE.toMovieComplete(movie);

        return ResponseEntity.ok(MovieComplete);
    }

    @PostMapping()
    public ResponseEntity<MovieComplete> create(@RequestBody Movie movie) {
        Movie movieCreated = movieCreateUseCase.execute(movie);
        MovieComplete movieComplete = MovieMapper.INSTANCE.toMovieComplete(movieCreated);

        return new ResponseEntity<>(movieComplete, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/actors")
    public ResponseEntity<Void> addActors(@PathVariable Integer id, @RequestBody List<Actor> actors) {
        movieAddActorsUseCase.execute(id, actors);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieComplete> update(@PathVariable Integer id, @RequestBody Movie movie) {
        movie.setId(id);
        Movie movieUpdated = movieUpdateUseCase.execute(movie);
        MovieComplete movieComplete = MovieMapper.INSTANCE.toMovieComplete(movieUpdated);

        return ResponseEntity.ok(movieComplete);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        movieDeleteUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}