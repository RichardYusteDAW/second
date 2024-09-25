package fpmislata.persistence.zdao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import fpmislata.domain.model.Movie;
import fpmislata.persistence.zdao.MovieDao;

@Repository
public class MovieDaoImpl implements MovieDao {

    private List<Movie> movList = new ArrayList<>();

    public MovieDaoImpl() {
        movList.add(
                new Movie(UUID.fromString("e7b28741-3d15-4946-83a5-7f6e6dc188c5"), "The Shawshank Redemption", 1994));
        movList.add(new Movie(UUID.fromString("a2cda9a8-9b84-4aeb-ae30-b93ef7cbe2f4"), "The Godfather", 1972));
        movList.add(new Movie(UUID.fromString("b9f3ea3b-6e47-4c4a-85b1-2f8c17d6d13f"), "The Dark Knight", 2008));
        movList.add(new Movie(UUID.fromString("c6d8241b-78e6-4f89-9f97-3484d1cb0ff1"), "Pulp Fiction", 1994));
        movList.add(new Movie(UUID.fromString("d3b8a68f-8a58-4a58-9a94-d741e77d5cc9"), "Forrest Gump", 1994));
    }

    @Override
    public List<Movie> findAll() {
        return movList;
    }

    @Override
    public Optional<Movie> findById(UUID id) {
        return movList.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean create(Movie movie) {
        movList.add(movie);
        return true;
    }

    @Override
    public boolean update(Movie movie) {
        movList.stream()
                .filter(m -> m.getId().equals(movie.getId()))
                .forEach(m -> {
                    m.setTitle(movie.getTitle());
                    m.setYear(movie.getYear());
                });
        return true;
    }

    @Override
    public boolean delete(UUID id) {
        movList.removeIf(m -> m.getId().equals(id));
        return true;
    }
}