package fpmislata.examen.d_persistence.zdao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import fpmislata.examen.a_common.annotation.Dao;
import fpmislata.examen.c_domain._2service.model.Director;
import fpmislata.examen.c_domain._2service.model.ListWithCount;
import fpmislata.examen.d_persistence.zdao.impl.jpa.DirectorJpa;
import fpmislata.examen.d_persistence.zdao.impl.mapper.DirectorDaoMapper;
import fpmislata.examen.d_persistence.zdao.impl.model.DirectorDaoModel;
import fpmislata.examen.d_persistence.zdao.interfaces.DirectorDao;
import lombok.RequiredArgsConstructor;

@Dao
@RequiredArgsConstructor
public class DirectorDaoImpl implements DirectorDao {

    private final DirectorJpa directorJpa;

    @Override
    public ListWithCount<Director> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<DirectorDaoModel> directorDaoModelPage = directorJpa.findAll(pageable);

        List<Director> directorList = directorDaoModelPage
                .stream()
                .map(directorDaoModel -> DirectorDaoMapper.INSTANCE.toDirector(directorDaoModel))
                .toList();

        return new ListWithCount<>(directorList, directorDaoModelPage.getTotalElements());
    }

    @Override
    public Optional<Director> findByMovieId(Integer movieId) {
        return directorJpa.findByMovieId(movieId)
                .map(directorDaoModel -> DirectorDaoMapper.INSTANCE.toDirector(directorDaoModel));
    }

    @Override
    public Optional<Director> findById(Integer id) {
        return directorJpa.findById(id)
                .map(directorDaoModel -> DirectorDaoMapper.INSTANCE.toDirector(directorDaoModel));
    }

    @Override
    public Director save(Director director) {
        DirectorDaoModel directorDaoModel = directorJpa.save(DirectorDaoMapper.INSTANCE.toDirectorDaoModel(director));
        return DirectorDaoMapper.INSTANCE.toDirector(directorDaoModel);
    }

    @Override
    public void delete(Integer id) {
        directorJpa.deleteById(id);
    }
}