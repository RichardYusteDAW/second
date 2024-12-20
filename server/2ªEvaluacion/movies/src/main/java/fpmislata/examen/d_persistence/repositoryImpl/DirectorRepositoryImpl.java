package fpmislata.examen.d_persistence.repositoryImpl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import fpmislata.examen.c_domain._2service.model.Director;
import fpmislata.examen.c_domain._2service.model.ListWithCount;
import fpmislata.examen.c_domain._3repository.DirectorRepository;
import fpmislata.examen.d_persistence.zdao.interfaces.DirectorDao;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DirectorRepositoryImpl implements DirectorRepository {

    private final DirectorDao directorDao;

    @Override
    public ListWithCount<Director> findAll(Integer page, Integer size) {
        return directorDao.findAll(page, size);
    }

    @Override
    public Optional<Director> findByMovieId(Integer movieId) {
        return directorDao.findByMovieId(movieId);
    }

    @Override
    public Optional<Director> findById(Integer id) {
        return directorDao.findById(id);
    }

    @Override
    public Director save(Director director) {
        return directorDao.save(director);
    }

    @Override
    public void delete(Integer id) {
        directorDao.delete(id);
    }
}