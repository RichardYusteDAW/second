package fpmislata.examen.d_persistence.repositoryImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import fpmislata.examen.c_domain._2service.model.Director;
import fpmislata.examen.c_domain._3repository.DirectorRepository;
import fpmislata.examen.d_persistence.zdao.interfaces.DirectorDao;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DirectorRepositoryImpl implements DirectorRepository {

    private final DirectorDao directorDao;

    @Override
    public List<Director> getAll(Integer page, Integer size) {
        return directorDao.getAll(page, size);
    }

    @Override
    public Optional<Director> findById(Integer id) {
        return directorDao.findById(id);
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<Integer> save(Director t) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}
