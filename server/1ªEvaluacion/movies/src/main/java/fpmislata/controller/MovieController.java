package fpmislata.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fpmislata.common.Color;
import fpmislata.domain.model.Movie;
import fpmislata.domain.service.MovieService;

@RestController
public class MovieController {

    MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> findAll() {
        try {
            return ResponseEntity.ok(movieService.findAll());
        } catch (Exception e) {
            System.err.println(Color.red("Error: " + e.getMessage()));
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> findById(@PathVariable UUID id) {
        Optional<Movie> movie = movieService.findById(id);
        System.out.println(movie.get().toString());
        return movie.isPresent()
                ? ResponseEntity.ok(movie.get())
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/movies")
    public ResponseEntity<Boolean> create(@RequestParam String title, @RequestParam Integer year) {
        Boolean created = movieService.create(title, year);
        return created
                ? ResponseEntity.ok(created)
                : ResponseEntity.badRequest().build();
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Boolean> update(@PathVariable UUID id, @RequestParam String title,
            @RequestParam Integer year) {
        Boolean updated = movieService.update(id, title, year);
        return updated
                ? ResponseEntity.ok(updated)
                : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable UUID id) {
        Boolean deleted = movieService.delete(id);
        return deleted
                ? ResponseEntity.ok(deleted)
                : ResponseEntity.badRequest().build();
    }
}