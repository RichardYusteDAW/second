package fpmislata.examen.b_presentation.admin.contoller;

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

import fpmislata.examen.b_presentation.admin.mapper.MovieMapper;
import fpmislata.examen.b_presentation.admin.model.MovieCollection;
import fpmislata.examen.b_presentation.admin.model.MovieDetail;
import fpmislata.examen.b_presentation.common.Paginator;
import fpmislata.examen.c_domain._1usecase.admin.movie.interfaces.MovieAddActorsUseCase;
import fpmislata.examen.c_domain._1usecase.admin.movie.interfaces.MovieCreateUseCase;
import fpmislata.examen.c_domain._1usecase.admin.movie.interfaces.MovieDeleteUseCase;
import fpmislata.examen.c_domain._1usecase.admin.movie.interfaces.MovieUpdateUseCase;
import fpmislata.examen.c_domain._1usecase.common.movie.interfaces.MovieCountUseCase;
import fpmislata.examen.c_domain._1usecase.common.movie.interfaces.MovieFindByIdUseCase;
import fpmislata.examen.c_domain._1usecase.common.movie.interfaces.MovieGetAllUseCase;
import fpmislata.examen.c_domain._2service.model.Actor;
import fpmislata.examen.c_domain._2service.model.Movie;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(MovieController.ENDPOINT)
public class MovieController {

    private final MovieGetAllUseCase movieGetAllUseCase;
    private final MovieCountUseCase movieCountUseCase;
    private final MovieFindByIdUseCase movieFindByIdUseCase;
    private final MovieCreateUseCase movieCreateUseCase;
    private final MovieUpdateUseCase movieUpdateUseCase;
    private final MovieDeleteUseCase movieDeleteUseCase;
    private final MovieAddActorsUseCase movieAddActorsUseCase;

    @Value("${url}")
    private String URL;
    public static final String ENDPOINT = "/api/admin/movies";

    @GetMapping()
    public ResponseEntity<Paginator<MovieCollection>> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {

        Integer total = movieCountUseCase.execute();
        List<Movie> movies = movieGetAllUseCase.execute(page - 1, size);
        List<MovieCollection> movieCollectionList = MovieMapper.INSTANCE.toMovieCollectionList(movies);
        Paginator<MovieCollection> paginator = new Paginator<>(movieCollectionList, total, page, size,
                URL + ENDPOINT);

        return ResponseEntity.ok(paginator);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDetail> findById(@PathVariable Integer id) {
        Movie movie = movieFindByIdUseCase.execute(id);
        MovieDetail MovieDetail = MovieMapper.INSTANCE.toMovieDetail(movie);

        return ResponseEntity.ok(MovieDetail);
    }

    @PostMapping()
    public ResponseEntity<Integer> create(@RequestBody Movie movie) {
        Integer movieId = movieCreateUseCase.execute(movie);

        return new ResponseEntity<>(movieId, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/actors")
    public ResponseEntity<Void> addActors(@PathVariable Integer id, @RequestBody List<Actor> actors) {
        movieAddActorsUseCase.execute(id, actors);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Integer> update(@RequestBody Movie movie) {
        Integer movieId = movieUpdateUseCase.execute(movie);

        return ResponseEntity.ok(movieId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        movieDeleteUseCase.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}